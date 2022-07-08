package com.zhuling.person.controller;

import com.zhuling.model.dto.request.GdsBaseRequest;
import com.zhuling.model.dto.request.GdsBookRequest;
import com.zhuling.model.dto.request.GdsCancelRequest;
import com.zhuling.model.dto.request.GdsIssueTicketRequest;
import com.zhuling.model.dto.request.GdsPayVerifyRequest;
import com.zhuling.model.dto.request.GdsValidateRequest;
import com.zhuling.model.dto.response.GdsBookResponse;
import com.zhuling.model.dto.response.GdsCancelResponse;
import com.zhuling.model.dto.response.GdsIssueTicketResponse;
import com.zhuling.model.dto.response.GdsPayVerifyResponse;
import com.zhuling.model.dto.response.GdsValidateResponse;
import com.zhuling.person.service.TraceLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("trace-log")
@Slf4j
public class TraceLogController {
    @Resource
    private TraceLogService traceLogService;

    @GetMapping
    public ResponseEntity<String> ok() {
        traceLogService.logItem(GdsBookRequest.builder().build(), GdsBookResponse.builder().build());
        traceLogService.logItem(GdsCancelRequest.builder().build(), GdsCancelResponse.builder().build());
        traceLogService.logItem(GdsIssueTicketRequest.builder().build(), GdsIssueTicketResponse.builder().build());
        traceLogService.logItem(GdsPayVerifyRequest.builder().build(), GdsPayVerifyResponse.builder().build());
        traceLogService.logItem(GdsValidateRequest.builder().build(), GdsValidateResponse.builder().build());
        return ResponseEntity.ok("ok");
    }
}
