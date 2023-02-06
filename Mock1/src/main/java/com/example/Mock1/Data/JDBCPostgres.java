package com.example.Mock1.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.sql.*;


public class JDBCPostgres {
    private final String dburl = "jdbc:postgresql://192.168.56.101:5432/mydb";
    private final String dblogin = "postgres";
    private final String dbpassword = "postgres";

    java.util.Date utilDateIn = new java.util.Date();
    java.sql.Date sqlDateIn = new java.sql.Date(utilDateIn.getTime());

    public User select(String loginFromJmeter) throws SQLException{
        Connection connection = null;
        String query = "select * from login_psw_date lpd\n" +
                "join login_email le on lpd.login = le.login\n" +
                "where lpd.login = " + loginFromJmeter;
        User user = new User();

        try {
            connection = DriverManager.getConnection(dburl, dblogin, dbpassword);
            Statement statement = connection.createStatement();
            System.out.println("connect ok");
            ResultSet result1 = statement.executeQuery(query);

            while (result1.next()) {
                user.setLogin(result1.getString("login"));
                user.setPassword(result1.getString("password"));
                user.setEmail(result1.getString("email"));
                user.setDate(result1.getDate("date").toString());
                System.out.println(user);
            }
        } catch (SQLException selectException) {
            System.out.println("Ошибка запроса select");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return user;
    }

    public String insert(String login, String password, String email) throws SQLException{
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
        return new String("{'status':'ok'}");
    }

    @ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
    public static class ServiceExceptionGet extends Exception {
        public ServiceExceptionGet(){}
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public static class ServiceExceptionPost extends Exception {
        public ServiceExceptionPost(){}
    }
}
