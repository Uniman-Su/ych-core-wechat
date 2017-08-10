package com.ych.core.wechat.pay;

/**
 * 微信支付的常量
 *
 * Created by U on 2017/7/19.
 */
public interface Constants extends com.ych.core.wechat.Constants {

    /**
     * 创建统一订单的URL
     */
    String CREATE_UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 查询订单信息的URL
     */
    String QUERY_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

    /**
     * 关闭订单信息的URL
     */
    String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";

    /**
     * 申请退款的URL
     */
    String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";

}
