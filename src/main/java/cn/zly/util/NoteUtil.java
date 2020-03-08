package cn.zly.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class NoteUtil {

    /**
     * 利用UUID算法生成主键
     *
     * @return
     */
    public static String createId() {
        String s = UUID.randomUUID().toString();
        return getMD5Str(getSHA256Str(s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
                + s.substring(19, 23) + s.substring(24)));
    }

    public static String getSHA256Str(Object... str) {
        return getAlgorithmStr("SHA-256", StandardCharsets.UTF_8, str);
    }

    public static String base64Encoder(String str) {
        return base64Encoder(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64Encoder(byte[] bytes) {
        try {
            return new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new NoteException("加密失败", e);
        }
    }

    public static String base64Decoder(String str) {
        return base64Decoder(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64Decoder(byte[] bytes) {
        try {
            return new String(Base64.getDecoder().decode(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new NoteException("加密失败", e);
        }
    }

    public static String base64UrlEncoder(String str) {
        return base64UrlEncoder(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64UrlEncoder(byte[] bytes) {
        try {
            return new String(Base64.getUrlEncoder().encode(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new NoteException("加密失败", e);
        }
    }

    public static String base64UrlDecoder(String str) {
        return base64UrlDecoder(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64UrlDecoder(byte[] bytes) {
        try {
            return new String(Base64.getUrlDecoder().decode(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new NoteException("解密失败", e);
        }
    }

    public static String getMD5Str(Object... str) {
        return getAlgorithmStr("MD5", StandardCharsets.UTF_8, str);
    }


    /**
     * 获取指定算法的字符串
     *
     * @param str
     * @return
     */
    public static String getAlgorithmStr(String algorithm, Charset encoder, Object... str) {
        try {
            String string = StringUtils.join(str);
            MessageDigest md5 = MessageDigest.getInstance(algorithm);
            md5.update(string.getBytes(StandardCharsets.UTF_8));
            byte[] messageDigest = md5.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++) {
                String t = Integer.toHexString(0xFF & messageDigest[i]);
                if (t.length() == 1) {
                    hexString.append("0").append(t);
                } else {
                    hexString.append(t);
                }
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isListNullOrEmpty(List list) {
        return list == null || list.size() == 0;
    }


    public static void main(String[] args) {
        System.out.println(getMD5Str("123456"));
        System.out.println(base64Encoder("MTIzNDU2"));
        System.out.println(createId());
        System.out.println(getSHA256Str(1).length());
    }

}
