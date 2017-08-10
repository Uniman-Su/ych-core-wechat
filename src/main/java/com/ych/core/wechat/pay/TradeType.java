package com.ych.core.wechat.pay;

/**
 * 交易类型
 *
 * Created by U on 2017/7/19.
 */
public enum TradeType {

    /**
     * 公众号支付
     */
    JSAPI,

    /**
     * 原生扫码支付
     */
    NATIVE,

    /**
     * app支付，统一下单接口trade_type的传参可参考这里
     */
    APP,

    /**
     * 卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
     */
    MICROPAY;

}
