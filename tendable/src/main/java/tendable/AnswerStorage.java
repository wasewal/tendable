package tendable;

import java.util.ArrayList;
import java.util.List;

/*
 * AnswerStorage will act as a storage for yes answers. 
 * Functionality of this class can be extended based on the requirement. 
 * current implementation is in accordance with current requirement and 
 * potential extensions are not implemented to be in adherence of YAGNI design principle.
 */

public class AnswerStorage {
    private List<String> answers;

    public AnswerStorage() {
        this.answers = new ArrayList<>();
    }

    public void storeAnswer(String answer) {
        answers.add(answer);
    }
    
    public List<String> getAnswers() {
        return answers;
    }

    public double calculateAverageRating() {
        if (answers.isEmpty()) {
            return 0.0;
        }

        int totalYesAnswers = 0;
        int totalQuestions = answers.size();

        for (String answer : answers) {
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                totalYesAnswers++;
            }
        }

        return (double) totalYesAnswers / totalQuestions * 100;
    }
}

