package com.example.springbootthymeleaf.realm;

import com.example.springbootthymeleaf.pojo.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;



public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //加密算法名称
    private static String algorithmName = "md5";
    //哈希的次数（加盐的次数）
    private static final int hashIterations = 2;

    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();
        user.setPassword(newPassword);
    }

    public static String encryptPassword(String passWord,String salt) {
        String newPassword = new SimpleHash(algorithmName, passWord,
                ByteSource.Util.bytes(salt), hashIterations).toHex();
        return newPassword;
    }
}
