package com.jk.demo.test.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
  public static String DRIVER = "com.mysql.jdbc.Driver";
  public static String URL = "jdbc:mysql://localhost:53306/web_demo";
  public static String USER = "root";
  public static String PASSWORD = "tt";

  public static void main(final String[] args) throws ClassNotFoundException {
    Class.forName(DRIVER);
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);

      select(conn);
      //      batchInsert(conn);
      //      insert(conn);

    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      close(conn);
    }
  }

  public static void insert(final Connection conn) {
    PreparedStatement ps = null;
    try {
      final String sql = "insert into user (id, name, age) values (?,?,?)";
      ps = conn.prepareStatement(sql);

      ps.setInt(1, 3);
      ps.setString(2, "alix");
      ps.setInt(3, 10);

      ps.execute();
    } catch (final SQLException e) {
      rollback(conn);
      e.printStackTrace();
    } finally {
      close(ps);
    }
  }

  public static void batchInsert(final Connection conn) {
    PreparedStatement ps = null;
    try {
      conn.setAutoCommit(false);

      final String sql = "insert into user (id, name, age) values (?,?,?)";
      ps = conn.prepareStatement(sql);

      for (int i = 0; i < 100; i++) {
        ps.setInt(1, i + 100);
        ps.setString(2, "alix" + i);
        ps.setInt(3, 10);
        ps.addBatch();
      }

      ps.executeBatch();

      conn.commit();

    } catch (final SQLException e) {
      rollback(conn);
      e.printStackTrace();
    } finally {
      close(ps);
    }
  }

  public static void select(final Connection conn) {
    PreparedStatement ps = null;
    ResultSet set = null;
    try {
      final String sql = "select * from user";
      ps = conn.prepareStatement(sql);

      set = ps.executeQuery();

      while (set.next()) {
        System.out.printf(
            "id: %d, name: %s, age: %d\n", set.getInt(1), set.getString(2), set.getInt(3));
      }

    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      close(set);
      close(ps);
    }
  }

  public static void close(final AutoCloseable app) {
    if (app != null) {
      try {
        app.close();
      } catch (final Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void rollback(final Connection conn) {
    if (conn != null) {
      try {
        conn.rollback();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
