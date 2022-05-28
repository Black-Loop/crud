package org.blackloop.crud.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
  private static final String URL = "jdbc:mysql://localhost:3306/Crud"; // 127.0.0.1
  private static final String USER = "root";
  private static final String PASSWORD = "AlzamorA109";

  public static java.sql.Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void close(java.sql.Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(java.sql.Statement statement) {
    try {
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void close(java.sql.ResultSet resultSet) {
    try {
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
