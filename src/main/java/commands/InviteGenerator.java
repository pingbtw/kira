package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class InviteGenerator extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if (messageSent[0].equalsIgnoreCase("!invite")) {
            event.getChannel().sendMessage(event.getChannel().createInvite()
                    .setMaxAge(60).complete().getURL()).queue();
        }
    }
}