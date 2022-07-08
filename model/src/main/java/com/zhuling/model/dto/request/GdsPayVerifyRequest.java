package com.zhuling.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsPayVerifyRequest extends GdsBaseRequest implements Serializable {
    public GdsPayVerifyRequest(String cid, String sessionId, String ds, String pcc) {
        super(cid, sessionId, ds, pcc);
    }

    public GdsPayVerifyRequest() {
    }
}
