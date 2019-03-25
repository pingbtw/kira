import Events.JoinListener;

import commands.MessageLogger;
import config.Token;
import features.Reactions;
import handler.AddNewUser;
import handler.CommandBot;
import model.SurveyToken;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    SurveyToken surveyToken = new SurveyToken(Token.GetToken("survey", "surveyId"));
    logger.info("{} Logger Operational", Main.class.getSimpleName());
    JDA jda = new JDABuilder(Token.GetToken("config", "token")).build();
    Reactions reactions = new Reactions(surveyToken);
    jda.addEventListener(
        new CommandBot().mod(reactions),
        new JoinListener(),
        new AddNewUser(),
        reactions,
        new MessageLogger());
  }
}
