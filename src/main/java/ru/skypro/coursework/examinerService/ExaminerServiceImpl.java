package ru.skypro.coursework.examinerService;

import org.springframework.stereotype.Service;
import ru.skypro.coursework.Question;
import ru.skypro.coursework.exception.BadAmountException;
import ru.skypro.coursework.questionService.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadAmountException("столько вопросов нет");
        }
        Set<Question> questions = new HashSet<>();
        while (amount > questions.size()) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}

