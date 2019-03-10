package Events;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageLogger extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(!event.getMember().getUser().isBot()) {
            System.out.println("Message from: " + event.getAuthor().getName()
                    + '#' + event.getAuthor().getDiscriminator()
                    + " - " + event.getMessage().getContentDisplay());
        }
    }
}
