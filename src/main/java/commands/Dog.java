package commands;

import com.google.gson.Gson;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class Dog extends Command {
    public Dog() {
        this.name = "dog";
        this.help = "random dog pic";

    }
    public void execute(CommandEvent commandEvent) {
        try {
            URL dog = new URL("https://dog.ceo/api/breeds/image/random");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(dog.openStream()));
            Gson gson = new Gson();
            Properties json = gson.fromJson(buffer, Properties.class);
            commandEvent.reply(json.getProperty("message"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
