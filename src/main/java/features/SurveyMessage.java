package features;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import model.SurveyToken;
import org.json.JSONObject;
import java.io.FileWriter;

public class SurveyMessage extends Command {
  private Reactions reactions;

  public SurveyMessage(Reactions reactions) {
    this.name = "survey";
    this.help = "Set survey post";
    this.reactions = reactions;
  }

  @Override
  public void execute(CommandEvent commandEvent) {
    String[] commandParameters = commandEvent.getMessage().getContentRaw().split(" ");
    String surveyID = commandParameters[1];
    String path = "";
    try {
      JSONObject json = new JSONObject();
      json.put("surveyId", surveyID);
      reactions.setSurveyToken(new SurveyToken(surveyID));
      FileWriter file = new FileWriter(path);
      file.write(json.toString());
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
