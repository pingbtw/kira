package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PingCommand extends Command {
    public PingCommand() {
        this.name = "ping";
        this.aliases = new String[]{"ping"};
        this.help = "responds with ping delay";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        int startTime = (int) System.currentTimeMillis();
        int elapsedTime = (int) System.currentTimeMillis();
        commandEvent.reply("Responded in " + (elapsedTime - startTime) + "ms");
    }
}
