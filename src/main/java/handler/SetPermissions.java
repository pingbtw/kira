package handler;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import database.MySqlConnector;

import java.sql.Statement;

public class SetPermissions extends Command {
    public SetPermissions() {
        this.name = "setpermission";
        this.aliases = new String[]{"sp"};
        this.help = "set user permissions";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {

        String[] args = commandEvent.getMessage().getContentRaw().split("\\s+");
        if(IsAllowed.isAllowed(commandEvent)) {
            if (args[1].equalsIgnoreCase("help")) {
                commandEvent.reply("`.setpermission [uid to update] [permission level]`");
            }
            else {
                try {
                    Statement myStmt = MySqlConnector.dbConnection().createStatement();
                    String sql = "update permissions set permissions = " + args[2] + " where id = " + args[1];
                    myStmt.executeUpdate(sql);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}