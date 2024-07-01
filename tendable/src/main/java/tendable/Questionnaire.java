package tendable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Questionnaire {
    private List<String> questions;

    public Questionnaire(String questionlistproperties) {
        this.questions = loadQuestionsFromProperties(questionlistproperties);
    }

    private List<String> loadQuestionsFromProperties(String questionlistproperties) {
        List<String> loadedQuestions = new ArrayList<>();
        Properties properties = new Properties();

        //Read the properties file for list of questions
        try (InputStream inputStream = getClass().getResourceAsStream(questionlistproperties)) {
            properties.load(inputStream);

            // Load questions using Java 8 streams into a List. 
            loadedQuestions = properties.keySet().stream()
                    .filter(key -> key.toString().startsWith("q"))
                    .map(key -> properties.getProperty(key.toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedQuestions;
    }

    public List<String> getQuestions() {
        return questions;
    }
}
