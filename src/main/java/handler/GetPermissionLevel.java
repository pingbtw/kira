package handler;

import database.MySqlConnector;

import java.sql.ResultSet;
import java.sql.Statement;

public class GetPermissionLevel {

    public static int getPermissions(String uid) {
    int level = 0;
        try {

        Statement myStmy = MySqlConnector.dbConnection().createStatement();
        String sql = "select permissions from permissions where id = " + uid;
        ResultSet myRs = myStmy.executeQuery(sql);
        while (myRs.next()) {
            level = Integer.valueOf(myRs.getString("permissions"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
        return level;
}
}
