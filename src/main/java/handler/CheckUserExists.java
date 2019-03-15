package handler;

import database.MySqlConnector;

import java.sql.ResultSet;
import java.sql.Statement;

public class CheckUserExists {
    public static boolean checkUserExists(String id) {
         Boolean exists = false;
         try {

             Statement myStmy = MySqlConnector.dbConnection().createStatement();
             ResultSet myRs = myStmy.executeQuery("select id from permissions where id = " + id);
             if (myRs.next()) {
                 exists = true;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return exists;
     }
}
