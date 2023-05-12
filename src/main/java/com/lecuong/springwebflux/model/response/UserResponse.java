package com.lecuong.springwebflux.model.response;

import lombok.Data;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:55 AM
 * @project spring-webflux
 */
@Data
public class UserResponse {

    private long id;
    private String email;
    private String name;
}
