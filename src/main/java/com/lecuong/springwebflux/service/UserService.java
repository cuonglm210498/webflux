package com.lecuong.springwebflux.service;

import com.lecuong.springwebflux.entity.User;
import com.lecuong.springwebflux.model.request.UserSaveRequest;
import com.lecuong.springwebflux.model.response.BaseResponse;
import com.lecuong.springwebflux.model.response.UserResponse;
import com.lecuong.springwebflux.model.request.UserUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:52 AM
 * @project spring-webflux
 */
public interface UserService {

    Mono<BaseResponse<UserResponse>> save(UserSaveRequest userSaveRequest);

    Mono<BaseResponse<Void>> delete(Long id);

    Mono<BaseResponse<UserResponse>> update(Long id, UserUpdateRequest userUpdateRequest);

    Mono<BaseResponse<UserResponse>> findById(Long id);

    Mono<BaseResponse<List<UserResponse>>> getAll();

    Mono<Page<UserResponse>> getAll(Pageable pageable);
}
