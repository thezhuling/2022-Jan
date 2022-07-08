package com.zhuling.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsBookRequest extends GdsBaseRequest implements Serializable {
    public GdsBookRequest(String cid, String sessionId, String ds, String pcc) {
        super(cid, sessionId, ds, pcc);
    }

    public GdsBookRequest() {
    }
}
