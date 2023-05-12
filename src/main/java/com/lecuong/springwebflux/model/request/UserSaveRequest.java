package com.lecuong.springwebflux.model.request;

import lombok.Data;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:56 AM
 * @project spring-webflux
 */
@Data
public class UserSaveRequest {

    private String email;
    private String name;
}
