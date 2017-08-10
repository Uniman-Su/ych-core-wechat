package com.ych.core.wechat.pay.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 退款请求
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundRequest extends AbstractRequest {

    /**
     * 调用接口提交的公众账号ID
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 调用接口提交的商户号
     */
    @JsonProperty("mch_id")
    private String merchantId;

    /**
     * 微信支付订单号
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    /**
     * 订单金额
     */
    @JsonProperty("total_fee")
    private int totalFee;

    /**
     * 退款金额
     */
    @JsonProperty("refund_fee")
    private int refundFee;

    /**
     * 货币种类
     */
    @JsonProperty("refund_fee_type")
    private String refundFeeType;

    /**
     * 货币种类
     */
    @JsonProperty("refund_desc")
    private String refundDesc;

    /**
     * 退款资金来源<br>
     * 仅针对老资金流商户使用
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    @JsonProperty("refund_account")
    private String refundAccount;

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
     * @return 货币种类
     */
    public String getRefundFeeType() {
        return refundFeeType;
    }

    /**
     * @param refundFeeType
     *         货币种类
     */
    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    /**
     * @return 货币种类
     */
    public String getRefundDesc() {
        return refundDesc;
    }

    /**
     * @param refundDesc
     *         货币种类
     */
    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    /**
     * 退款资金来源,仅针对老资金流商户使用
     *
     * @return REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）<br>
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    public String getRefundAccount() {
        return refundAccount;
    }

    /**
     * 退款资金来源,仅针对老资金流商户使用
     *
     * @param refundAccount
     *         REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）<br>
     *         REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }
}
