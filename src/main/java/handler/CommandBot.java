package handler;


import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import commands.*;
import features.Reactions;
import features.SurveyMessage;
import net.dv8tion.jda.core.entities.Game;


public class CommandBot {

    public CommandClient mod(Reactions reactions) {

        CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
        commandClientBuilder.setPrefix(".");
        commandClientBuilder.setHelpWord("802f02jf9j2390j90");
        commandClientBuilder.setGame(Game.playing("Learning2Bot"));
        commandClientBuilder.setOwnerId("");
        commandClientBuilder.addCommands(
                new SetPermissions(),
                new SurveyMessage(reactions),
                new xkcd(),
                new PingCommand(),
                new Dog(),
                new EightBall());

        return commandClientBuilder.build();
    }
}

