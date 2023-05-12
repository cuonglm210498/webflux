package com.lecuong.springwebflux.model.request;

import lombok.Data;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:53 AM
 * @project spring-webflux
 */
@Data
public class UserUpdateRequest {

    private String email;
    private String name;
}
