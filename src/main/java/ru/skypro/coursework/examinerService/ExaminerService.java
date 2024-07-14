package ru.skypro.coursework.examinerService;

import ru.skypro.coursework.Question;

import java.util.Collection;

public interface ExaminerService {
     Collection<Question> getQuestions(int amount);


}