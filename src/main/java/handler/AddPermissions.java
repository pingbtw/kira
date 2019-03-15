package handler;

import database.MySqlConnector;

import java.sql.Statement;

public class AddPermissions {
    public static void addPermissions(String id, int permissions) {

        try {
            Statement myStmt = MySqlConnector.dbConnection().createStatement();
            String sql = "Insert into permissions (id, permissions) values (" + id + ", " + permissions + ")";
            myStmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
