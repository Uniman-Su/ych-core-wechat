package com.ych.core.wechat.pay;

/**
 * 错误码集合
 */
public interface ErrorCode {
    /**
     * 成功的错误码
     */
    String SUCCESS = "SUCCESS";
    /**
     * 失败的错误码
     */
    String FAIL = "FAIL";

    /**
     * 此交易订单号不存在
     */
    String ORDER_NOT_EXIST = "ORDERNOTEXIST";

    /**
     * 系统错误
     */
    String SYSTEM_ERROR = "SYSTEMERROR";

    /**
     * 商户无此接口权限
     */
    String NO_AUTH = "NOAUTH";

    /**
     * 余额不足
     */
    String NOT_ENOUGH = "NOTENOUGH";

    /**
     * 商户订单已支付
     */
    String ORDER_PAID = "ORDERPAID";

    /**
     * 订单已关闭
     */
    String ORDER_CLOSED = "ORDERCLOSED";

    /**
     * APPID不存在
     */
    String APPID_NOT_EXIST = "APPID_NOT_EXIST";

    /**
     * MCHID不存在
     */
    String MCHID_NOT_EXIST = "MCHID_NOT_EXIST";

    /**
     * appid和mch_id不匹配
     */
    String APPID_MCHID_NOT_MATCH = "APPID_MCHID_NOT_MATCH";

    /**
     * 缺少参数
     */
    String LACK_PARAMS = "LACK_PARAMS";

    /**
     * 商户订单号重复
     */
    String OUT_TRADE_NO_USED = "OUT_TRADE_NO_USED";

    /**
     * 签名错误
     */
    String SIGN_ERROR = "SIGNERROR";

    /**
     * XML格式错误
     */
    String XML_FORMAT_ERROR = "XML_FORMAT_ERROR";

    /**
     * 请使用post方法
     */
    String REQUIRE_POST_METHOD = "REQUIRE_POST_METHOD";

    /**
     * post数据为空
     */
    String POST_DATA_EMPTY = "POST_DATA_EMPTY";

    /**
     * 编码格式错误
     */
    String NOT_UTF8 = "NOT_UTF8";

}
