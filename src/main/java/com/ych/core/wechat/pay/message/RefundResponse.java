package com.ych.core.wechat.pay.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.fasterxml.jackson.databind.deser.YNStrBooleanDeserializer;
import com.ych.core.wechat.fasterxml.jackson.deser.DateStringDeserializer;
import com.ych.core.wechat.pay.TradeState;
import com.ych.core.wechat.pay.TradeType;

/**
 * 退款响应
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundResponse extends ReturnResult {

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
     * 商户退款单号
     */
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    @JsonProperty("refund_id")
    private String refundId;

    /**
     * 退款金额
     */
    @JsonProperty("refund_fee")
    private int refundFee;

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
     * 现金退款金额
     */
    @JsonProperty("cash_refund_fee")
    private Integer cashRefundFee;

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
     * @return 商户退款单号
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * @param outRefundNo
     *         商户退款单号
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    /**
     * @return 应结订单金额
     */
    public int getRefundFee() {
        return refundFee;
    }

    /**
     * @param refundFee
     *         应结订单金额
     */
    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    /**
     * @return 微信退款单号
     */
    public String getRefundId() {
        return refundId;
    }

    /**
     * @param refundId
     *         微信退款单号
     */
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    /**
     * @return 现金退款金额
     */
    public Integer getCashRefundFee() {
        return cashRefundFee;
    }

    /**
     * @param cashRefundFee
     *         现金退款金额
     */
    public void setCashRefundFee(Integer cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

}
