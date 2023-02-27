package unipiDBalumni;

import java.sql.*;
import java.util.Scanner;

public class JDBCconnection1 {
  public static void main(String[] args) throws SQLException {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      // Load the JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // Establish a connection to the database
      conn = DriverManager.getConnection("jdbc:sqlserver://<host>:<port>;databaseName=<unipi_alumni>", "unipiProject", "unipi123");

      // Create a Statement object
      statement = conn.createStatement();

      // Present the menu to the user
      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.println("\nEnter a number to select a query:");
        System.out.println("1. Select");
        System.out.println("2. Insert");
        System.out.println("3. Delete");
        System.out.println("4. Call stored procedure");
        System.out.println("5. Call index");
        System.out.println("6. Call trigger");
        System.out.println("7. Quit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
          System.out.print("Enter a SELECT statement: ");
          String selectSQL = scanner.nextLine();
          resultSet = statement.executeQuery(selectSQL);
          printResultSet(resultSet);
        } else if (choice == 2) {
          System.out.print("Enter an INSERT statement: ");
          String insertSQL = scanner.nextLine();
          int rowsAffected = statement.executeUpdate(insertSQL);
          System.out.println(rowsAffected + " row(s) affected");
        } else if (choice == 3) {
          System.out.print("Enter a DELETE statement: ");
          String deleteSQL = scanner.nextLine();
          int rowsAffected = statement.executeUpdate(deleteSQL);
          System.out.println(rowsAffected + " row(s) affected");
        } else if (choice == 4) {
          System.out.print("Enter a stored procedure name: ");
          String storedProcedure = scanner.nextLine();
          CallableStatement callableStatement = conn.prepareCall("{ call " + storedProcedure + " }");
          callableStatement.execute();
          System.out.println("Stored procedure executed");
        } else if (choice == 5) {
          System.out.print("Enter an index name: ");
          String index = scanner.nextLine();
          resultSet = statement.executeQuery("EXEC sp_helpindex '" + index + "'");
          printResultSet(resultSet);
        } else if (choice == 6) {
          System.out.print("Enter a trigger name: ");
          String trigger = scanner.nextLine();
          resultSet = statement.executeQuery("SELECT *
