package Events;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {
    private static String newUser;
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        newUser = event.getUser().getAsMention();
        TextChannel general = event.getGuild().getTextChannelsByName("general", true).get(0);
        general.sendMessage("Welcome " + newUser).queue();
    }
}
