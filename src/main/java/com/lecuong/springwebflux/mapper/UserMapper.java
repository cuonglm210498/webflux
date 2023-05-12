package com.lecuong.springwebflux.mapper;

import com.lecuong.springwebflux.entity.User;
import com.lecuong.springwebflux.model.response.UserResponse;
import com.lecuong.springwebflux.model.request.UserSaveRequest;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 9:00 AM
 * @project spring-webflux
 */
@Data
@Component
public class UserMapper {

    private final ModelMapper mapper;

    public User to(UserSaveRequest userSaveRequest) {
        return mapper.map(userSaveRequest, User.class);
    }

    public UserResponse to(User user) {
        return mapper.map(user, UserResponse.class);
    }
}
