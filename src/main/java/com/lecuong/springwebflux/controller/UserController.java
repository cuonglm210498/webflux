package com.lecuong.springwebflux.controller;

import com.lecuong.springwebflux.entity.User;
import com.lecuong.springwebflux.model.request.UserSaveRequest;
import com.lecuong.springwebflux.model.response.BaseResponse;
import com.lecuong.springwebflux.model.response.UserResponse;
import com.lecuong.springwebflux.repository.UserRepository;
import com.lecuong.springwebflux.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 9:13 AM
 * @project spring-webflux
 */
@Data
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    public Mono<BaseResponse<UserResponse>> save(@RequestBody UserSaveRequest userSaveRequest) {
        return userService.save(userSaveRequest);
    }

    @DeleteMapping("/{id}")
    public Mono<BaseResponse<Void>> delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<BaseResponse<UserResponse>> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public Mono<BaseResponse<List<UserResponse>>> getAll() {
        return userService.getAll();
    }
}
