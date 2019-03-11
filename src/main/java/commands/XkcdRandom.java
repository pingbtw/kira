package commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class XkcdRandom extends Command {
    public XkcdRandom() {
        this.name = "random";
        this.arguments = "xkcd";
        this.aliases = new String[]{"xkcdrnd"};
        this.help = "Get a random image from xkcd";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        int rand = (int) (Math.random() * ((2121 - 1) + 1)) + 1;
        commandEvent.reply("http://xkcd.com/" + rand);
    }
}