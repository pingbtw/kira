import Events.JoinListener;
import Events.MessageLogger;
import java.io.BufferedReader;
import java.io.FileReader;

import handler.CommandBot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Main {

    private final static Logger logger
            = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        logger.info("{} Logger Operational", Main.class.getSimpleName());
        JDA jda = new JDABuilder(GetToken("token")).build();
        jda.addEventListener(
                new CommandBot().mod(),
                new JoinListener(),
                new MessageLogger());
    }

        public static String GetToken(String value) throws Exception {
            String path = "path";
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            Properties json = gson.fromJson(buffer, Properties.class);
            return ((json).getProperty(value));
        }
    }