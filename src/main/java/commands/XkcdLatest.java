package commands;

import com.google.gson.Gson;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class XkcdLatest extends Command {
    int num;
    public XkcdLatest() {
        this.name = "latest";
        this.arguments = "xkcd";
        this.aliases = new String[]{"xkcdltst"};
        this.help = "Get the latest image from XkcdLatest";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        try {
            String json = xkcdParser();
            Gson gson = new Gson();
            XkcdLatest page = gson.fromJson(json, XkcdLatest.class);
            commandEvent.reply("http://xkcd.com/" + page.num);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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