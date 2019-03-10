package Events;

import com.google.gson.Gson;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;


public class FunCommands extends ListenerAdapter {

    public static class XKCD {
        int num;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if (messageSent[0].equals("!xkcd random")) {
            int rand = (int) (Math.random() * ((2121 - 1) + 1)) + 1;
            event.getChannel().sendMessage("http://xkcd.com/" +
                    rand).queue();
        }

        if (messageSent[0].equals("!xkcd latest")) {
            try {
                String json = xkcdParser();
                Gson gson = new Gson();
                XKCD page = gson.fromJson(json, XKCD.class);
                event.getChannel().sendMessage("http://xkcd.com/" + page.num).queue();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        if (messageSent[0].equalsIgnoreCase("!ping")) {
            long startTime = System.currentTimeMillis();
            if (!event.getMember().getUser().isBot()) {
                long elapsedTime = System.currentTimeMillis();
                event.getChannel().sendMessage("Responded in " + (elapsedTime - startTime) + "ms").queue();
            }
        }

        if (messageSent[0].equalsIgnoreCase("!8ball")) {
            event.getChannel().sendMessage(EightBall()).queue();
        }

        if (messageSent[0].equalsIgnoreCase("!invite")) {
            event.getChannel().sendMessage(event.getChannel().createInvite().setMaxAge(60).complete().getURL()).queue();
        }
    }

    private static String xkcdParser() throws Exception {
        BufferedReader reader = null;
        try {
            URL xkcd = new URL("https://xkcd.com/info.0.json");
            reader = new BufferedReader(new InputStreamReader(xkcd.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    public static String EightBall() {
        String[] outcomes = new String[]{
                "Certainly", "Decidedly so", "Unlikely", "I have a good feeling about this", "No.", "Yes", "Maybe"
        };
        int output = new Random().nextInt((7) +1) +1;
        return outcomes[output];
    }
}

