package com.zhuling.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsValidateResponse<T> extends GdsBaseResponse<T> implements Serializable {
    public GdsValidateResponse(Integer status, String message, T data) {
        super(status, message, data);
    }

    public GdsValidateResponse() {
        super();
    }
}
