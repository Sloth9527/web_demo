package com.jk.demo.utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
  public static void close(Closeable co) {
    try {
      co.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
