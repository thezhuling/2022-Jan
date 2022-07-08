package com.zhuling.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GdsBaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -8899337117100421584L;
    /**
     * 响应状态码
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 业务对象
     */
    private T data;
}
