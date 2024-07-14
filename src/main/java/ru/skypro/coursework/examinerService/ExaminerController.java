package ru.skypro.coursework.examinerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.coursework.Question;

import java.util.Collection;

@RestController
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/exam/java/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
