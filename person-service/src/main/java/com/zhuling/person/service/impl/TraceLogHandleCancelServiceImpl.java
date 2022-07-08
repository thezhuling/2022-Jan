package com.zhuling.person.service.impl;

import com.zhuling.model.dto.comm.TraceLog;
import com.zhuling.model.dto.request.GdsBaseRequest;
import com.zhuling.model.dto.response.GdsBaseResponse;
import com.zhuling.person.service.TraceLogHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("traceLogHandleCancelService")
@Slf4j
public class TraceLogHandleCancelServiceImpl implements TraceLogHandleService {
    @Override
    public TraceLog buildTraceLog(GdsBaseRequest gdsBaseRequest, GdsBaseResponse gdsBaseResponse) {
        log.info("traceLogHandleCancelService execute");
        return TraceLog.builder().build();
    }
}
