package com.zhuling.model.dto.comm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraceLog implements Serializable {
    private String cid;
    private String toCity;
    private String fromDate;
    private String retDate;
    private String tripType;
    private String flightClass;
    private String ds;
    private String pcc;
    private Integer status;
    private Integer errorCode;
    private String sessionId;
    private String requestPayload;
    private String responsePayload;
}
