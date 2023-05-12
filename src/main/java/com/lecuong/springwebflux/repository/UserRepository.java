package com.lecuong.springwebflux.repository;

import com.lecuong.springwebflux.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 11:09 AM
 * @project spring-webflux
 */
@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
}
