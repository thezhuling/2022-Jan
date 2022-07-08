package com.zhuling.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsValidateRequest extends GdsBaseRequest implements Serializable {
    public GdsValidateRequest(String cid, String sessionId, String ds, String pcc) {
        super(cid, sessionId, ds, pcc);
    }

    public GdsValidateRequest() {
    }
}
