package com.planb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FBPUtils {
    public static String getHashedPassword(String password) throws NoSuchAlgorithmException {
        String hashedPassword = null;
        if (password != null) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hashedPassword = sb.toString();
        } else {
            System.out.println("Password is null");
        }
        return hashedPassword;
    }

    public int addUserToDatabase(FBPUser user) {
        // Placeholder for database insertion logic
        // Return 1 for success, 0 for failure
        int result = 0;
        String insertSQL = "INSERT INTO User " +
                "(displayName, firstName, lastName, emailAddress, hashedPassword) " +
                "VALUES (?, ?, ?, ?, ?)";
        // Call jdbc servlet to execute the insertSQL with user data

        return result;
    }
}
