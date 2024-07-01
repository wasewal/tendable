package tendable;

import java.util.List;
import java.util.Scanner;

public class Survey {
    private Questionnaire questionnaire;
    private AnswerStorage answerStorage;
    private Scanner scanner;

    public Survey() {
        this.scanner = new Scanner(System.in);
    }
    

    public AnswerStorage getAnswerStorage() {
		return answerStorage;
	}


	public void setAnswerStorage(AnswerStorage answerStorage) {
		this.answerStorage = answerStorage;
	}


	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}


	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}


	public void conductSurvey() {
    	List<String> questions = questionnaire.getQuestions();
        int numberOfQuestions = questions.size();

        // Using IntStream.range to iterate through indices of questions
        java.util.stream.IntStream.range(0, numberOfQuestions)
                .forEach(i -> {
                    String question = questions.get(i);
                    System.out.println(question);
                    String answer = promptForAnswer();
                    answerStorage.storeAnswer(answer);

                    // Calculate rating for this run
                    long numberOfYesAnswers = answerStorage.getAnswers().stream()
                            .limit(i + 1) // Only consider answers up to current question
                            .filter(a -> a.equalsIgnoreCase("yes") || a.equalsIgnoreCase("y"))
                            .count();
                    double rating = getCurrentRating(numberOfYesAnswers,numberOfQuestions);

                    // Print rating for this run after each answer
                    System.out.printf("Rating after question %d: %.2f%%\n", (i + 1), rating);
                });

        // Calculate and print average rating across all runs
        double averageRating = answerStorage.calculateAverageRating();
        System.out.printf("Average rating across all runs: %.2f%%\n", averageRating);
    }

    private String promptForAnswer() {
        String answer;
        do {
            System.out.print("Your answer (Yes/No): ");
            answer = scanner.nextLine().trim().toLowerCase();
        } while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no") ||
                   answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));
        return answer;
    }

	public double getCurrentRating(long numberOfYesAnswers,int numberOfQuestions) {
		return (double) numberOfYesAnswers / numberOfQuestions * 100;
	}
}
