package pl.kinert.malgorzata.github.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public static final String DIVISION_BY_ZERO = "Division by zero";

    public double calculateUserData(Integer followers, Integer publicRepos) {
        //throws ArithmeticException (division by 0) if followers=0
        if (followers == 0) {
            throw new ArithmeticException(DIVISION_BY_ZERO);
        }
        return  6.0d / followers * (2 + publicRepos);
    }
}
