package com.ych.core.wechat.pay.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.fasterxml.jackson.databind.deser.YNStrBooleanDeserializer;
import com.ych.core.wechat.fasterxml.jackson.deser.DateStringDeserializer;
import com.ych.core.wechat.pay.TradeType;

/**
 * 支付通知
 * <p>
 * Created by U on 2017/7/19.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayNotify extends ReturnResult {

    /**
     * 公众账号ID
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 商户号
     */
    @JsonProperty("mch_id")
    private String merchantId;

    /**
     * 设备号
     */
    @JsonProperty("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     */
    @JsonProperty("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 签名类型
     */
    @JsonProperty("sign_type")
    private String signType;

    /**
     * 业务结果
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
     * 用户标识
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 是否关注公众账号
     */
    @JsonProperty("is_subscribe")
    @JsonDeserialize(using = YNStrBooleanDeserializer.class)
    private boolean subscribe;

    /**
     * 交易类型
     */
    @JsonProperty("trade_type")
    private TradeType tradeType;

    /**
     * 付款银行
     */
    @JsonProperty("bank_type")
    private String bankType;

    /**
     * 订单金额
     */
    @JsonProperty("total_fee")
    private int totalFee;

    /**
     * 应结订单金额
     */
    @JsonProperty("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 货币种类
     */
    @JsonProperty("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     */
    @JsonProperty("cash_fee")
    private int cashFee;

    /**
     * 现金支付货币类型
     */
    @JsonProperty("cash_fee_type")
    private String cashFeeType;

    /**
     * 微信支付订单号
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /**
     * 商家数据包
     */
    @JsonProperty("attach")
    private String attach;

    /**
     * 支付完成时间
     */
    @JsonProperty("time_end")
    @JsonDeserialize(using = DateStringDeserializer.class)
    private Date payTime;

    /**
     * @return 公众账号ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *         公众账号ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return 商户号
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     *         商户号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 设备号
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * @param deviceInfo
     *         设备号
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * @return 随机字符串
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * @param nonceStr
     *         随机字符串
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    /**
     * @return 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     *         签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return 签名类型
     */
    public String getSignType() {
        return signType;
    }

    /**
     * @param signType
     *         签名类型
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * @return 业务结果
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     *         业务结果
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

    /**
     * @return 用户标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     *         用户标识
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return 是否关注公众账号
     */
    public boolean isSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe
     *         是否关注公众账号
     */
    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return 交易类型
     */
    public TradeType getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType
     *         交易类型
     */
    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * @return 付款银行
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * @param bankType
     *         付款银行
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * @return 订单金额
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee
     *         订单金额
     */
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return 应结订单金额
     */
    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    /**
     * @param settlementTotalFee
     *         应结订单金额
     */
    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    /**
     * @return 货币种类
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * @param feeType
     *         货币种类
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /**
     * @return 现金支付金额
     */
    public int getCashFee() {
        return cashFee;
    }

    /**
     * @param cashFee
     *         现金支付金额
     */
    public void setCashFee(int cashFee) {
        this.cashFee = cashFee;
    }

    /**
     * @return 现金支付货币类型
     */
    public String getCashFeeType() {
        return cashFeeType;
    }

    /**
     * @param cashFeeType
     *         现金支付货币类型
     */
    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    /**
     * @return 微信支付订单号
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId
     *         微信支付订单号
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return 商户订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * @param outTradeNo
     *         商户订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * @return 商家数据包
     */
    public String getAttach() {
        return attach;
    }

    /**
     * @param attach
     *         商家数据包
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * @return 支付完成时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     *         支付完成时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
