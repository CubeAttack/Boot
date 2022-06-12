package de.cubeattack.boot;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;

public class AuthenticationCode {

    public static void main(String[] args) {
        String output = "68bac1e2b2f9c1cad71648c22d4966e800f9728c";

        String password = "Sehr Geheim";
        String time = String.valueOf(System.currentTimeMillis()/1000/30);

        String hash = hmacSha1(password, time);
        hash = hmacSha1(hash, String.valueOf(hash.hashCode()));

        System.out.println(hash);
    }

    public static String hmacSha1(String value, String key) {
        try {
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(value.getBytes());

            String string = toHexString(rawHmac);

            return string;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }
}
