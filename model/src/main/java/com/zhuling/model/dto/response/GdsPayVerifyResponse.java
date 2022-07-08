package com.zhuling.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsPayVerifyResponse<T> extends GdsBaseResponse<T> implements Serializable {
    public GdsPayVerifyResponse(Integer status, String message, T data) {
        super(status, message, data);
    }

    public GdsPayVerifyResponse() {
        super();
    }
}
