package pl.kinert.malgorzata.github.requestcounter.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserRequestCounterMapper {
    @Insert("INSERT INTO USERS (login, request_count) VALUES(#{login}, 1) " +
            "ON DUPLICATE KEY UPDATE request_count = request_count + 1")
    void insertUserOrIncrementCounter(@Param("login") String login);
}
