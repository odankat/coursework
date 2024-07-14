package ru.skypro.coursework.questionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.coursework.Question;

import java.util.Collection;
import java.util.Set;


public class JavaQuestionServiceTest {
    private QuestionService questionService;

    @BeforeEach
    public void rest() {
        questionService = new JavaQuestionService();
    }

    @Test
    void correctAdd() {
        String qustion = "qustion";
        String answer = "answer";
        Question expectedQuestion = new Question("qustion", "answer");
        Question actualQuestion = questionService.add(qustion, answer);
        Question actualQuestion1 = questionService.add(expectedQuestion);
        Assertions.assertEquals(qustion, actualQuestion.getQuestion());
        Assertions.assertEquals(answer, actualQuestion.getAnswer());
        Assertions.assertEquals(expectedQuestion, actualQuestion1);
    }

    @Test
    void correctRemove() {
        Question question = new Question("qustion", "answer");
        questionService.add(question);
        questionService.remove(question);
        Assertions.assertEquals(question, question);

    }

    @Test
    void getAll() {
        Question question = new Question("qustion", "answer");
        Question question1 = new Question("qustion1", "answer1");
        questionService.add(question);
        questionService.add(question1);
        Collection<Question> actual = questionService.getAll();
        Assertions.assertEquals(actual, Set.of(question, question1));
    }

    @Test
    void getRandomQuestion() {
        Question question = new Question("qustion", "answer");
        Question question1 = new Question("qustion1", "answer1");
        questionService.add(question);
        questionService.add(question1);
        Question actual = questionService.getRandomQuestion();
        Assertions.assertTrue(Set.of(question, question1).contains(actual));
    }
}