package com.zhuling.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GdsCancelRequest extends GdsBaseRequest implements Serializable {
    public GdsCancelRequest(String cid, String sessionId, String ds, String pcc) {
        super(cid, sessionId, ds, pcc);
    }

    public GdsCancelRequest() {
    }
}
