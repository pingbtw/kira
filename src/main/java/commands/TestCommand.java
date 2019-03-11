package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class TestCommand extends Command {
    public TestCommand() {
        this.name = "test";
        this.aliases = new String[]{"tst"};
        this.help = "This be a test";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.reply("test success");
    }
}