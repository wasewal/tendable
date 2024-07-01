package tendable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionnaireTest {

    private Questionnaire questionnaire;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize Questionnaire instance for each test
        questionnaire = new Questionnaire("/mock-questions.properties");
    }

    @Test
    public void testLoadQuestions() throws IOException {
        List<String> questions = questionnaire.getQuestions();
        assertEquals(5, questions.size()); // Assuming mock-questions.properties has 5 questions. Please update the assertion condition if question list is updated.
    }
}

