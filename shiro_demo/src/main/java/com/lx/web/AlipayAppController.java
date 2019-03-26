package com.lx.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.lx.alipay.config.AlipayConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/alipay")
@SuppressWarnings("all")
public class AlipayAppController {

    @RequestMapping("createOrder")
    public Map<String,Object> alipay() {

        String orderNo = UUID.randomUUID().toString();

        //实例化客户端
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        //商品描述，可空
        model.setBody("支付0.01元购买gg币");
        //订单名称，必填
        model.setSubject("购买gg币");
        //订单号，必填
        model.setOutTradeNo(orderNo);
        //超时时间，可空
        model.setTimeoutExpress("30m");
        //支付金额，必填
        model.setTotalAmount("0.01");
        //产品编号，必填
        model.setProductCode("QUICK_WAP_PAY");
        request.setBizModel(model);
        //外网可访问的异步地址
        request.setNotifyUrl(AlipayConfig.notify_url);
        Map<String, Object> map = new HashMap<>();
        try {
            AlipayTradeAppPayResponse response = client.sdkExecute(request);
            //就是orderString 可以直接给客户端请求，无需再做处理。
           String orderStr = response.getBody();
            System.out.println("---------------------------------------"+ orderStr + "-----------------------------------------------");

            map.put("orderStr",orderStr);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 支付宝支付成功后回调该接口
     * @return
     */
    @RequestMapping("notify")
    public String aliNotify(HttpServletRequest request, HttpServletResponse response) {

        Map requestParams = request.getParameterMap();
        Map<String,String> params = new HashMap<>();
        for(Iterator iterator = requestParams.keySet().iterator();iterator.hasNext();) {
            String name = iterator.next().toString();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            if (name.equals("trade_status")) {
                System.out.println("交易状态为："+valueStr);
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");

            params.put(name, valueStr);

        }
        //获取支付宝的通知返回参数
        //商户订单号
        try {
        /*String out_trade_no=new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号
        String trade_no=new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //买家登录支付宝id
        String buyer_logon_id = new String(request.getParameter("buyer_logon_id").getBytes("ISO-8859-1"),"UTF-8");
        //交易时间
        String gmt_payment = new String(request.getParameter("gmt_payment").getBytes("ISO-8859-1"),"UTF-8");
        //交易金额
        String invoice_amount = new String(request.getParameter("invoice_amount").getBytes("ISO-8859-1"),"UTF-8");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =null;


            date =  format.parse(gmt_payment);*/

        // poublicKey为应用公钥换取的支付宝公钥

        // 验证签名
        boolean b = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, "UTF-8",AlipayConfig.SIGNTYPE);
        //验证通过
        if (b) {
            //交易状态为成功
            if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
                /*
                 * 支付成功后的业务逻辑以后应该写在这里。
                 * 将支付信息存根
                 */

                return "SUCCESS";
            }

        }
        return "error:验证签名失败";
    } catch (Exception e) {
        // TODO: handle exception
        return "支付异常";
    }
    }
}
