package com.zhuling.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsIssueTicketResponse<T> extends GdsBaseResponse<T> implements Serializable {
    public GdsIssueTicketResponse(Integer status, String message, T data) {
        super(status, message, data);
    }

    public GdsIssueTicketResponse() {
        super();
    }
}
