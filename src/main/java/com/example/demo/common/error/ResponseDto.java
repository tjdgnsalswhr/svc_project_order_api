package com.example.demo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private T data;
    private ErrorVo errorVo;

    public ResponseDto(T data) {
        this(data, new ErrorVo());
    }

    public ResponseDto(ErrorVo errorVo) {
        this(null, errorVo);
    }
}
