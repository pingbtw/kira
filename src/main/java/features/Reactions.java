package features;

import model.SurveyToken;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;

public class Reactions extends ListenerAdapter {

  private ArrayList<String> userIds = new ArrayList<>();
  private SurveyToken surveyObject;

  public void setSurveyToken(SurveyToken surveyToken) {
    this.surveyObject = surveyToken;
  }

  public Reactions(SurveyToken surveyToken) {
    this.surveyObject = surveyToken;
  }

  public void onMessageReactionAdd(MessageReactionAddEvent event) {

    if (event.getReaction().getMessageId().equals(surveyObject.getSurvey())
        && !userIds.contains(event.getUser().getId())) {
      userIds.add(event.getUser().getId());
      event
          .getUser()
          .openPrivateChannel()
          .queue(
              (channel) ->
                  channel.sendMessage("I see you are interested in taking a survey!").queue());
    }
  }
}
