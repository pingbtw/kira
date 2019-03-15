package handler;


import Events.EightBall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import commands.*;
import net.dv8tion.jda.core.entities.Game;

import java.io.FileWriter;


public class CommandBot {

    public CommandClient mod() {

        CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
        commandClientBuilder.setPrefix(".");
        commandClientBuilder.setHelpWord("802f02jf9j2390j90");
        commandClientBuilder.setGame(Game.playing("Learning2Bot"));
        commandClientBuilder.setOwnerId("394574967448141826");
        commandClientBuilder.addCommands(
                new SetPermissions(),
                new xkcd(),
                new PingCommand(),
                new EightBall());
        return commandClientBuilder.build();
    }
}

