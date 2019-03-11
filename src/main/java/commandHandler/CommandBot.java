package commandHandler;


import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.*;
import net.dv8tion.jda.core.entities.Game;


public class CommandBot {

    public CommandClient mod() {

        CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
        commandClientBuilder.setPrefix("!!");
        commandClientBuilder.setGame(Game.playing("Learning2Bot"));
        commandClientBuilder.setOwnerId("394574967448141826");
        commandClientBuilder.addCommands(
                new XkcdRandom(),
                new XkcdLatest(),
                new PingCommand(),
                new TestCommand(),
                new EightBall());
        return commandClientBuilder.build();
    }
}
