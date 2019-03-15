package handler;


import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class IsAllowed extends ListenerAdapter {
    public static boolean isAllowed(CommandEvent commandEvent) {
        boolean isAllowed = false;
        String[] args = commandEvent.getMessage().getContentRaw().split("\\s+");
        String commandName = args[0].replace(".", "");
        String author = commandEvent.getAuthor().getId();
        if (GetPermissionLevel.getPermissions(author) >= (CommandLevel.commandLevel(commandName))) {
            isAllowed = true;
        }
        if (GetPermissionLevel.getPermissions(author) < (CommandLevel.commandLevel(commandName))) {
            commandEvent.reply("You really thought i'd let you do that?");
            isAllowed = false;
        }
    return isAllowed;
    }
}
