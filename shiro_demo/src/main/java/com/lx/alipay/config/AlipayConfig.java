package com.lx.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016092800614709";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCvk0HjjmnWUzsokKjMjXdWtj3j7gHkZUn9y0lX2ZzAInMeHmrUOZRGbgdZHO/pHZZJig1KDSmsvCf7xyZCFndtd4QPL3YSSHSr63vqbH20IReb5rkLRlUxY0ldh2MRk39FBC/e4eMajq3+k8T6slDirit3EcsUBnPPlarEp0FRy043EsCe5ieU5+cTN2dGnHKzj/i06zy8bJiT8V05jQdL2sGNxyOr+jF1A6K7QRx1k8yXqCuO2wjXCm2zlD9GHSTxW+nzNW2mPZ7zu5STljYlHWbYoFxt2yM/GhmiVhpsZxN5tDK7wSIHibHJcKjattqPa+aq31X9pRzYiXQECEGFAgMBAAECggEAbsnTB84zhqRabgxqFzklFrhEcXEcDIzFlboS+7Y7LRoP3e9/pY73u0FurZKO6GBdFuZf4FxR8ceAy2UtBQK8NXz2/cYLERpbVKhxNsliwKkpBp0eIrksxM9L2hK2Nr8Fzf0IX/HVpkpmDIAeCbs/Qup4TtgRdv9jUJe2fAS2OO+t/Whv/5HcmtqQgJ9t+F6wdzJFBM5fmYo3gb7a24ABE+3Kmf3tH21mSc5h/ic9BsEvAgdj/Xf9G52pHzQUbUo38POJ1FuoSWUnd5RgZWEmwWXW90iGgV33NKOIBxz4vkrAHssHTQ7aOdYVoLeAOt8umTWK3YiYQ4VFhLQcJRYp+QKBgQDp9Sqb5Rg1GmDzM1/dWC3lFNOYCWv3/59woht514eUXB0SwPaB1AyeQOvB2KurojHpeF0GjfUSu4RH9mRSgEs2FLdDrEuEn7RRbgH5RBRLXPNbmoCDY35fAZueXK7reG/zFi+yqP71PE9IuHk5+smzBsktpSRN4P+EE9AeZSzcLwKBgQDAHfZfb55z9CZis26bYJeUDxAx7OJst0sDi4ejHIWczyL66CYUDIgA+j7a09fFM54r2kFQYYGyfEaqe1Ni10kXdsnmGemMFoLcAnnbiCcm4Brv3I26y2o4l5wxC2g3CtLZEK6k8W2a/faUKMSdsm4hLg5ZeOawIelgM0NTqC2MiwKBgA6chi24UBu46wclVT5grHUbKN/c7sZNS6rgJPEmGcyVOCecr4iKMsOLcG3p10bf2VgocT7gjMa/uVI5PCi+5HObNZrfXtQImV1gjnT/4HiYdIZrDs2l4BWU5yArz6zbF7rJzu7MiSfNvXHgO4n4dLJeoR/dqXfHro2UIzJSxUt3AoGBAKzjye5E4tHy7ABy/ZzypjZl/+sOBQ5VPTqpfJz7c/qUJiSqemochOBsU9hWQJ2FQFiyh4iw1ykq0eVmKrqOh4aILlXXB+g78fPQfp1jv+gqUdN+JkXt/V+EgNlaLKUsJmeVrbVeV4bd+eOHdLl988IEUoGOXfwv6HfcakCE3sjVAoGBAMx09LMLdFYiWG/P9KmRdi8xg/iIi9WUyo0fkOk+jrmFyL2kc8c43kedrzvdwD1AXhGWZ5UkIr501mHbmO4VjHLBr7TJigzwJ4X3+C5i5W4y7VE+WVV/eAz4GyxCPkpn7RsxoiDebJx8uvaTU1rT9iNqJ8/I31NUrP13hDxE3YDp";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://r3ys5r.natappfree.cc/api/h5/notify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://r3ys5r.natappfree.cc";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
