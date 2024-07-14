package ru.skypro.coursework.examinerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.coursework.Question;
import ru.skypro.coursework.exception.BadAmountException;
import ru.skypro.coursework.questionService.JavaQuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void correctGetQuestions() {
        int amount = 2;
        List<Question> list = List.of(
                new Question("1111", "1111"),
                new Question("2222", "2222"),
                new Question("4444", "4444"));
        when(javaQuestionService.getAll()).thenReturn(list);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                list.get(0),
                list.get(1),
                list.get(0)
        );
        Collection<Question> actual = examinerService.getQuestions(amount);
        Assertions.assertEquals(Set.of(list.get(0), list.get(1)), actual);
        verify(javaQuestionService, times(2)).getRandomQuestion();

    }

    @Test
    void coorectException() {
        List<Question> list = List.of(
                new Question("1111", "1111"),
                new Question("2222", "2222"),
                new Question("3333", "3333"),
                new Question("4444", "4444"));
        int amount = 6;
        when(javaQuestionService.getAll()).thenReturn(list);
        Assertions.assertThrows(BadAmountException.class,
                () -> examinerService.getQuestions(amount));
    }
}