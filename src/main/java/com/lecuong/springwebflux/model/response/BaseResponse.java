package com.lecuong.springwebflux.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author CuongLM18
 * @created 11/05/2023 - 9:03 AM
 * @project spring-webflux
 */
@Getter
@Setter
public class BaseResponse<T> {

    private HttpStatus code;
    private T data;

    public BaseResponse(HttpStatus code, T data) {
        this.code = code;
        this.data = data;
    }
}
