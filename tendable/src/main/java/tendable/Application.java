package tendable;

public class Application {

	  public static void main(String[] args) {
	        Survey survey = new Survey();
	        survey.setQuestionnaire(new Questionnaire("/questions.properties"));
	        survey.setAnswerStorage(new AnswerStorage());
	        survey.conductSurvey();
	    }
}
