package handler;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

public class AddNewUser extends ListenerAdapter {
    
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String id = event.getAuthor().getId();
        int permissions = 1;
        if (!CheckUserExists.checkUserExists(id) && !event.getAuthor().isBot()) {
            List userRoles = event.getMember().getRoles();
            for (int i = 0; i < userRoles.size(); i++) {
                if (userRoles.get(i).toString().contains("Operator")) {
                    permissions = 3;
                }
                if (userRoles.get(i).toString().contains("Admin")) {
                    permissions = 4;
                }
                if (userRoles.get(i).toString().contains("Owner")) {
                    permissions = 5;
                }
            }
            AddPermissions.addPermissions(id, permissions);
        }
    }
}
