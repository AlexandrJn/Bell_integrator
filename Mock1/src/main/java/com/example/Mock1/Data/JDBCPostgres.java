package com.example.Mock1.Data;
import java.sql.*;


public class JDBCPostgres {
    final String dburl = "jdbc:postgresql://192.168.56.101:5432/mydb";
    final String dblogin = "postgres";
    final String dbpassword = "postgres";
    public void driverJdbcPostgres() throws Exception{
        Class.forName("org.postgresql.Driver");
    }

    java.util.Date utilDateIn = new java.util.Date();
    java.sql.Date sqlDateIn = new java.sql.Date(utilDateIn.getTime());

    public void select(String loginFromJmeter) throws SQLException{
        Connection connection = null;
        String query = "select * from login_psw_date lpd\n" +
                "join login_email le on lpd.login = le.login\n" +
                "where lpd.login = " + loginFromJmeter;

        try {
            connection = DriverManager.getConnection(dburl, dblogin, dbpassword);
            Statement statement = connection.createStatement();
            System.out.println("connect select ok");
            ResultSet result1 = statement.executeQuery(query);
            while (result1.next()) {
                String login = result1.getString("login");
                String password = result1.getString("password");
                String email = result1.getString("email");
                java.sql.Date sqlDateOut = result1.getDate("date");
                //String dateOut = new SimpleDateFormat("dd/MM/yyyy").format(sqlDateOut);
                System.out.println(login + ", " + password + ", " + email);
            }
            System.out.println("Select ok");
        } catch (SQLException selectException){
            System.out.println("Ошибка запроса select");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void insert(String login, String password, String email) throws SQLException{
        String query = "INSERT INTO login_email (login, email) values (?, ?);\n" +
                "INSERT INTO login_psw_date (login, password, date) values (?, ?, ?);";
        try (Connection connection1 = DriverManager.getConnection(dburl, dblogin, dbpassword);
             PreparedStatement preparedStatement = connection1.prepareStatement(query)){

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setDate(5, sqlDateIn);
            preparedStatement.executeUpdate();

        } catch (SQLException insertException){
            System.out.println("Ошибка запроса insert");
        }
    }
}
