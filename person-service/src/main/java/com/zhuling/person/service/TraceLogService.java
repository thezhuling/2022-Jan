package com.zhuling.person.service;


import com.zhuling.model.dto.request.GdsBaseRequest;
import com.zhuling.model.dto.response.GdsBaseResponse;


public interface TraceLogService {
    void logItem(GdsBaseRequest gdsBaseRequest, GdsBaseResponse gdsBaseResponse);
}

