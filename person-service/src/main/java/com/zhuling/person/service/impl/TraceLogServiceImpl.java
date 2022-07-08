package com.zhuling.person.service.impl;

import com.zhuling.model.dto.comm.TraceLog;
import com.zhuling.model.dto.request.GdsBaseRequest;
import com.zhuling.model.dto.request.GdsBookRequest;
import com.zhuling.model.dto.request.GdsCancelRequest;
import com.zhuling.model.dto.request.GdsIssueTicketRequest;
import com.zhuling.model.dto.request.GdsPayVerifyRequest;
import com.zhuling.model.dto.request.GdsValidateRequest;
import com.zhuling.model.dto.response.GdsBaseResponse;
import com.zhuling.model.dto.response.GdsBookResponse;
import com.zhuling.model.dto.response.GdsCancelResponse;
import com.zhuling.model.dto.response.GdsIssueTicketResponse;
import com.zhuling.model.dto.response.GdsPayVerifyResponse;
import com.zhuling.model.dto.response.GdsValidateResponse;
import com.zhuling.person.service.TraceLogHandleService;
import com.zhuling.person.service.TraceLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TraceLogServiceImpl implements TraceLogService {
    @Resource(name = "traceLogHandleBookService")
    private TraceLogHandleService traceLogHandleBookService;
    @Resource(name = "traceLogHandleCancelService")
    private TraceLogHandleService traceLogHandleCancelService;
    @Resource(name = "traceLogHandleIssueTicketService")
    private TraceLogHandleService traceLogHandleIssueTicketService;
    @Resource(name = "traceLogHandlePayVerifyService")
    private TraceLogHandleService traceLogHandlePayVerifyService;
    @Resource(name = "traceLogHandleValidateService")
    private TraceLogHandleService traceLogHandleValidateService;

    private final Map<String, TraceLogHandleService> services = new HashMap<>(8);

    @PostConstruct
    public void postConstruct() {
        services.put(StringUtils.joinWith("#", GdsBookRequest.class.getName(), GdsBookResponse.class.getName()),
                traceLogHandleBookService);

        services.put(StringUtils.joinWith("#", GdsCancelRequest.class.getName(), GdsCancelResponse.class.getName()),
                traceLogHandleCancelService);

        services.put(StringUtils.joinWith("#", GdsIssueTicketRequest.class.getName(), GdsIssueTicketResponse.class.getName()),
                traceLogHandleIssueTicketService);

        services.put(StringUtils.joinWith("#", GdsPayVerifyRequest.class.getName(), GdsPayVerifyResponse.class.getName()),
                traceLogHandlePayVerifyService);

        services.put(StringUtils.joinWith("#", GdsValidateRequest.class.getName(), GdsValidateResponse.class.getName()),
                traceLogHandleValidateService);
    }

    @Override
    public void logItem(GdsBaseRequest gdsBaseRequest, GdsBaseResponse gdsBaseResponse) {
        log.info("gdsBaseRequest###simpleName:{}", gdsBaseRequest.getClass().getSimpleName());
        String reqClass = gdsBaseRequest.getClass().getName();
        String repClass = gdsBaseResponse.getClass().getName();
        String key = StringUtils.joinWith("#", reqClass, repClass);
        TraceLogHandleService traceLogHandleService = services.get(key);
        TraceLog traceLog = traceLogHandleService
                .buildTraceLog(gdsBaseRequest, gdsBaseResponse);
        log.info("traceLog:{}", traceLog);
    }
}
