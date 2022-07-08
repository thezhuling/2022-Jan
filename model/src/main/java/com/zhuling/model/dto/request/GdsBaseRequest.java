package com.zhuling.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GdsBaseRequest implements Serializable {
    private static final long serialVersionUID = -3928122796596659198L;

    private String cid;
    private String sessionId;
    private String ds;
    private String pcc;
}
