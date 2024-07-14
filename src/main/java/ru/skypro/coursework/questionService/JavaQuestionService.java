package ru.skypro.coursework.questionService;

import org.springframework.stereotype.Service;
import ru.skypro.coursework.Question;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {
    final private Set<Question> questions = new HashSet<>();
    private final Random r = new Random();

    @Override
    public Question add(String question, String answer) {
        questions.add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }


    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(questions);
        int x = r.nextInt(questionList.size());
        return questionList.get(x);
    }
}
