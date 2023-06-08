package com.Service.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SaltedHash {
    private static final int SALT_LENGTH = 16;

    public static String hash(String password) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        String encodedSalt = bytesToHex(salt);
        String encodedHash = bytesToHex(hash);
        return encodedSalt + encodedHash;
    }

    public static boolean check(String password, String hashedPassword) throws NoSuchAlgorithmException {
        String encodedSalt = hashedPassword.substring(0, SALT_LENGTH * 2);
        String encodedHash = hashedPassword.substring(SALT_LENGTH * 2);
        byte[] salt = hexToBytes(encodedSalt);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        String encodedNewHash = bytesToHex(hash);
        return encodedHash.equals(encodedNewHash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return bytes;
    }
}