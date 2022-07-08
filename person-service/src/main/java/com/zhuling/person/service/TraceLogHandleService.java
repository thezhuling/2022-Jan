package com.zhuling.person.service;

import com.zhuling.model.dto.comm.TraceLog;
import com.zhuling.model.dto.request.GdsBaseRequest;
import com.zhuling.model.dto.response.GdsBaseResponse;

public interface TraceLogHandleService {
    TraceLog buildTraceLog(GdsBaseRequest gdsBaseRequest, GdsBaseResponse gdsBaseResponse);
}
