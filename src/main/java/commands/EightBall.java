package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Random;

public class EightBall extends Command {
    public EightBall() {
        this.name = "8ball";
        this.aliases = new String[]{"8b"};
        this.help = "Ask and you shall receive";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.reply(eightBall());
    }

    public static String eightBall() {
        String[] outcomes = new String[]{
                "Certainly", "Decidedly so", "Unlikely", "I have a good feeling about this", "No.", "Yes", "Maybe"
        };
        int output = new Random().nextInt((7) +1) +1;
        return outcomes[output];
    }
}