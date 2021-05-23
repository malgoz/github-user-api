package pl.kinert.malgorzata.github.requestcounter.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.kinert.malgorzata.github.requestcounter.mapper.UserRequestCounterMapper;

@Aspect
@Component
@RequiredArgsConstructor
public class UserRequestCounterAOP {

    private final UserRequestCounterMapper userRequestCounterMapper;

    @After("execution(* pl.kinert.malgorzata.github.rest.controller.GithubUserController.getUser(..)) && args(login)")
    public void requestCounterIncrementationAdvice(String login){
        userRequestCounterMapper.insertUserOrIncrementCounter(login);
    }
}
