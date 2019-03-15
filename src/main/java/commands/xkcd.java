package commands;

import com.google.gson.Gson;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import handler.CommandBot;
import handler.IsAllowed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class xkcd extends Command {
    int num;
    public xkcd() {
        this.name = "xkcd";
        this.aliases = new String[]{"xkcdltst"};
        this.help = "Get the latest image from xkcd";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if (IsAllowed.isAllowed(commandEvent)) {
            String[] arguments = commandEvent.getArgs().split("\\s+");
            if (arguments[0].equalsIgnoreCase("latest")) {
                try {
                    String json = xkcdParser();
                    Gson gson = new Gson();
                    xkcd page = gson.fromJson(json, xkcd.class);
                    commandEvent.reply("http://xkcd.com/" + page.num);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            if (arguments[0].equalsIgnoreCase("random")) {
                int rand = (int) (Math.random() * ((2121 - 1) + 1)) + 1;
                commandEvent.reply("http://xkcd.com/" + rand);
            }
        }
    }
    public static String xkcdParser() throws java.io.IOException {
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
}