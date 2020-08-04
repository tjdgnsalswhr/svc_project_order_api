package com.example.demo.order.core.application.object.query;


import com.example.demo.common.error.ErrorVo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDTO<T> {
    private T data;
    private ErrorVo errorVo;

    public ResponseDTO(T data) {
        this(data, new ErrorVo());
    }

    public ResponseDTO(ErrorVo errorVo) {
        this(null, errorVo);
    }
}
