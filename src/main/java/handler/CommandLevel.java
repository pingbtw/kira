package handler;

import database.MySqlConnector;

import java.sql.ResultSet;
import java.sql.Statement;

public class CommandLevel {

    public static int commandLevel(String commandName) {
        int level = 0;
        try {

            Statement myStmy = MySqlConnector.dbConnection().createStatement();
            String sql = "select " + commandName + " from commandLevel;";
            ResultSet myRs = myStmy.executeQuery(sql);
            while (myRs.next()) {
                level = myRs.getInt(commandName);
            }

    } catch (Exception e) {
            e.printStackTrace();
        }

        return level;
    }
}
