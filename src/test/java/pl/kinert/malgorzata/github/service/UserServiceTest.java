package pl.kinert.malgorzata.github.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCalculateUserData() {
        double excepted = 0.015995734470807783;
        double actual = userService.calculateUserData(3751, 8);
        assertEquals(excepted, actual);
    }

    @Test
    public void testCalculateUserDataShouldThrowArithmeticException() {
        String exceptedMessage = "Division by zero";
        Throwable exception = assertThrows(ArithmeticException.class, () ->  userService.calculateUserData(0, 8));
        assertEquals(exceptedMessage, exception.getMessage());
    }
}
