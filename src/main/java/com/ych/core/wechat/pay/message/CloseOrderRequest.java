package com.ych.core.wechat.pay.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 关闭订单请求
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseOrderRequest extends OrderQueryRequest {

    @Override
    public String getTransactionId() {
        return null;
    }

    @Override
    public void setTransactionId(String transactionId) {
    }

}
