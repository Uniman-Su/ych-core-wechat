package com.ych.core.wechat.pay.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 需要包含返回结果的父类
 * <p>
 * Created by U on 2017/7/19.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnResult {

    /**
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    @JsonProperty("return_code")
    private String returnCode;

    /**
     * 返回信息，如非空，为错误原因
     * 签名失败
     * 参数格式校验错误
     */
    @JsonProperty("return_msg")
    private String returnMsg;

    /**
     * SUCCESS/FAIL
     */
    @JsonProperty("result_code")
    private String resultCode;

    /**
     * 错误代码
     */
    @JsonProperty("err_code")
    private String errorCode;

    /**
     * 错误代码描述
     */
    @JsonProperty("err_code_des")
    private String errorCodeDesc;

    /**
     * @return SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * @param returnCode
     *         SUCCESS/FAIL
     *         此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * @return 返回信息，如非空，为错误原因
     * 签名失败
     * 参数格式校验错误
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * @param returnMsg
     *         返回信息，如非空，为错误原因
     *         签名失败
     *         参数格式校验错误
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    /**
     * @return SUCCESS/FAIL
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     *         SUCCESS/FAIL
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return 错误代码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *         错误代码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return 错误代码描述
     */
    public String getErrorCodeDesc() {
        return errorCodeDesc;
    }

    /**
     * @param errorCodeDesc
     *         错误代码描述
     */
    public void setErrorCodeDesc(String errorCodeDesc) {
        this.errorCodeDesc = errorCodeDesc;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
