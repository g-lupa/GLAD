package ryerson.ca.lab3.Persistence;

import ryerson.ca.lab3.Helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_CRUD {

    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GLAD?serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "student123");
            System.out.println("Connection established.");
        }
        catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Different Error");
        }

        return con;
    }

    public static UserInfo read(String username, String password) {
        UserInfo bean = null;
        String query = "SELECT * FROM USERS WHERE Username = '" + username + "';";

        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String adr = rs.getString("Email");
                String phone = rs.getString("Phone");
                String pass = rs.getString("Password");

                if (pass.equals(password)) {
                    bean = new UserInfo(fname, lname, adr, phone, username, password);
                }
            }
            con.close();
        }catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("error!");
        }

        return bean;
    }
}
