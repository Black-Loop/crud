package org.blackloop.crud.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
  private static final String URL = "jdbc:postgresql://ec2-3-234-131-8.compute-1.amazonaws.com/da37pjej4juiu7"; // 127.0.0.1
  private static final String USER = "wekahtpkiwzdbo";
  private static final String PASSWORD = "95d5a06f0fc4623a66c9d703684b0741cdba23b59c23d6858037e0fae778a269";

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
