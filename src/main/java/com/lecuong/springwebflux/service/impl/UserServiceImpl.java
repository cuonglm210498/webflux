package com.lecuong.springwebflux.service.impl;

import com.lecuong.springwebflux.entity.User;
import com.lecuong.springwebflux.mapper.UserMapper;
import com.lecuong.springwebflux.model.request.UserSaveRequest;
import com.lecuong.springwebflux.model.request.UserUpdateRequest;
import com.lecuong.springwebflux.model.response.BaseResponse;
import com.lecuong.springwebflux.model.response.UserResponse;
import com.lecuong.springwebflux.repository.UserRepository;
import com.lecuong.springwebflux.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:57 AM
 * @project spring-webflux
 */
@Data
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Mono<BaseResponse<UserResponse>> save(UserSaveRequest userSaveRequest) {
        User user = userMapper.to(userSaveRequest);
        return userRepository.save(user)
                .map(u -> new BaseResponse<>(HttpStatus.OK, userMapper.to(u)));
    }

    @Override
    public Mono<BaseResponse<Void>> delete(Long id) {
        Mono<User> userMono = userRepository.findById(id);
        return userMono.map(user -> {
            if (user != null)
                return new BaseResponse<>(HttpStatus.OK, null);
            throw new RuntimeException("Not found");
        });
    }

    @Override
    public Mono<BaseResponse<UserResponse>> update(Long id, UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public Mono<BaseResponse<UserResponse>> findById(Long id) {
        Mono<User> userMono = userRepository.findById(id);
        return userMono.map(user -> {
            if(user != null) {
                return new BaseResponse<>(HttpStatus.OK, userMapper.to(user));
            }  else {
                throw new RuntimeException("Not found");
            }
        });
    }

    @Override
    public Mono<BaseResponse<List<UserResponse>>> getAll() {
        Mono<List<User>> users = userRepository.findAll().collectList();
        return users.map(user -> {
            List<UserResponse> userResponses = user.stream().map(userMapper::to).collect(Collectors.toList());
            return new BaseResponse(HttpStatus.OK, new ArrayList<>(userResponses));
        });
    }

    @Override
    public Mono<Page<UserResponse>> getAll(Pageable pageable) {
        return null;
    }
}
