package com.ych.core.wechat.pay.message;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.fasterxml.jackson.databind.ser.ObjectJSONSerializer;
import com.ych.core.wechat.fasterxml.jackson.ser.DateStringSerializer;
import com.ych.core.wechat.pay.TradeType;

/**
 * 统一下单请求报文
 * <p>
 * Created by U on 2017/7/19.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnifiedOrderRequest extends AbstractRequest {

    /**
     * 微信支付分配的公众账号ID
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 微信支付分配的商户号
     */
    @JsonProperty("mch_id")
    private String merchantId;

    /**
     * 自定义参数，可以为终端设备号
     */
    @JsonProperty("device_info")
    private String deviceInfo;

    /**
     * 商品简单描述
     */
    private String body;

    /**
     * 商品详细描述
     */
    private String detail;

    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /**
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @JsonProperty("fee_type")
    private String feeType;

    /**
     * 订单总金额，单位为分
     */
    @JsonProperty("total_fee")
    private int totalFee;

    /**
     * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    @JsonProperty("spbill_create_ip")
    private String terminalIp;

    /**
     * 订单生成时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("time_start")
    @JsonSerialize(using = DateStringSerializer.class)
    private Date startTime;

    /**
     * 订单失效时间，格式为yyyyMMddHHmmss
     */
    @JsonProperty("time_expire")
    @JsonSerialize(using = DateStringSerializer.class)
    private Date expires;

    /**
     * 订单优惠标记
     */
    @JsonProperty("goods_tag")
    private String goodsTag;

    /**
     * 异步接收微信支付结果通知的回调地址
     */
    @JsonProperty("notify_url")
    private String notifyUrl;

    /**
     * 交易类型
     */
    @JsonProperty("trade_type")
    private TradeType tradeType;

    /**
     * trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义
     */
    @JsonProperty("product_id")
    private String productId;

    /**
     * 上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    @JsonProperty("limit_pay")
    private String limitPay;

    /**
     * trade_type=JSAPI时（即公众号支付），此参数必传
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据
     */
    @JsonProperty("scene_info")
    @JsonSerialize(using = ObjectJSONSerializer.class)
    private SceneInfo sceneInfo;

    /**
     * @return 微信支付分配的公众账号ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *         微信支付分配的公众账号ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return 微信支付分配的商户号
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     *         微信支付分配的商户号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 自定义参数，可以为终端设备号
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * @param deviceInfo
     *         自定义参数，可以为终端设备号
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * @return 商品简单描述
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body
     *         商品简单描述
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return 商品详细描述
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     *         商品详细描述
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    public String getAttach() {
        return attach;
    }

    /**
     * @param attach
     *         附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * @return 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * @param outTradeNo
     *         商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * @return 符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * @param feeType
     *         符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /**
     * @return 订单总金额，单位为分
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee
     *         订单总金额，单位为分
     */
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    public String getTerminalIp() {
        return terminalIp;
    }

    /**
     * @param terminalIp
     *         APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp;
    }

    /**
     * @return 订单生成时间，格式为yyyyMMddHHmmss
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *         订单生成时间，格式为yyyyMMddHHmmss
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 订单失效时间，格式为yyyyMMddHHmmss
     */
    public Date getExpires() {
        return expires;
    }

    /**
     * @param expires
     *         订单失效时间，格式为yyyyMMddHHmmss
     */
    public void setExpires(Date expires) {
        this.expires = expires;
    }

    /**
     * @return 订单优惠标记
     */
    public String getGoodsTag() {
        return goodsTag;
    }

    /**
     * @param goodsTag
     *         订单优惠标记
     */
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    /**
     * @return 异步接收微信支付结果通知的回调地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * @param notifyUrl
     *         异步接收微信支付结果通知的回调地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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
     * @return trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     *         trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return 上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    public String getLimitPay() {
        return limitPay;
    }

    /**
     * @param limitPay
     *         上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    /**
     * @return trade_type=JSAPI时（即公众号支付），此参数必传
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     *         trade_type=JSAPI时（即公众号支付），此参数必传
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return 该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据
     */
    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    /**
     * @param sceneInfo
     *         该字段用于上报场景信息，目前支持上报实际门店信息。该字段为JSON对象数据
     */
    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

}
