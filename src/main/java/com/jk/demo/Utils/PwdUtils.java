package com.jk.demo.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdUtils {
  private static final String SALT = System.getenv("SALT");

  public static String encryption(String pwd) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
      md.update((pwd + SALT).getBytes());
      return new BigInteger(1, md.digest()).toString(16);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  };
}
