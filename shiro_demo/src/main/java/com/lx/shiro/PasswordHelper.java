package com.lx.shiro;

import com.lx.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String hashAlgorithmName = "md5";
    private final int hashIterations = 2;

    public void encryptPassword(User user) {
        //设置加盐
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(hashAlgorithmName,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),hashIterations).toHex();
        user.setPassword(newPassword);

    }

}
