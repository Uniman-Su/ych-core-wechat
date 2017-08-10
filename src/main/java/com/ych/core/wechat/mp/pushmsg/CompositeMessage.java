package com.ych.core.wechat.mp.pushmsg;

import java.math.BigInteger;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.fasterxml.jackson.databind.deser.DateUnixTimestampDeserializer;
import com.ych.core.fasterxml.jackson.databind.ser.DateUnixTimestampSerializer;
import com.ych.core.wechat.mp.MsgType;
import com.ych.core.wechat.mp.VoiceFormat;

/**
 * 复合消息对象,在接收消息时统一对报文进行解析<br>
 * 接受微信消息通知的控制器可以直接将请求报文转换为该对象
 * <p>
 * Created by U on 2017/6/30.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositeMessage implements ITextMessage, IImageMessage, IVoiceMessage, IVideoMessage, ILocationMessage, ILinkMessage, ILocationEvent, IPushEvent, IQRScanEvent, IMenuEvent, IViewMenuEvent, IVerifyEvent, IVerifyFailedEvent {

    private static final long serialVersionUID = -7335045967948293607L;

    /**
     * 消息接收方
     */
    @JsonProperty("ToUserName")
    private String receiver;

    /**
     * 消息发送方
     */
    @JsonProperty("FromUserName")
    private String sender;

    /**
     * 创建时间
     */
    @JsonProperty("CreateTime")
    @JsonSerialize(using = DateUnixTimestampSerializer.class)
    @JsonDeserialize(using = DateUnixTimestampDeserializer.class)
    private Date createTime;

    /**
     * 消息类型
     */
    @JsonProperty("MsgType")
    private MsgType msgType;

    /**
     * 事件类型
     */
    @JsonProperty("Event")
    private EventType eventType;

    /**
     * 消息标题
     */
    @JsonProperty("Title")
    private String title;

    /**
     * 消息内容
     */
    @JsonProperty("Content")
    private String content;

    /**
     * 媒体ID
     */
    @JsonProperty("MediaId")
    private String mediaId;

    /**
     * 图片URL
     */
    @JsonProperty("PicUrl")
    private String picUrl;

    /**
     * 纬度
     */
    @JsonProperty("Latitude")
    private Double latitude;

    /**
     * 消息ID
     */
    @JsonProperty("MsgId")
    private BigInteger msgId;

    /**
     * 语音消息格式
     */
    @JsonProperty("Format")
    private VoiceFormat format;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    @JsonProperty("ThumbMediaId")
    private String thumbMediaId;

    /**
     * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
     */
    @JsonProperty("MenuID")
    private String menuId;

    /**
     * 消息描述
     */
    @JsonProperty("Description")
    private String description;

    /**
     * 经度
     */
    @JsonProperty("Longitude")
    private Double longitude;

    /**
     * 语音识别内容
     */
    @JsonProperty("Recognition")
    private String recognition;

    /**
     * 事件KEY值<br>
     * 用户未关注时扫描,之后进行关注,推送类似"qrscene_123123",qrscene_为前缀,后面为二维码的参数值<br>
     * 用户已关注时扫描是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    @JsonProperty("EventKey")
    private String eventKey;

    /**
     * 消息链接
     */
    @JsonProperty("Url")
    private String url;

    /**
     * 纬度
     */
    @JsonProperty("Location_X")
    private Double locationX;

    /**
     * 经度
     */
    @JsonProperty("Location_Y")
    private Double locationY;

    /**
     * 地图缩放大小
     */
    @JsonProperty("Scale")
    private Integer scale;

    /**
     * 地理位置精度
     */
    @JsonProperty("Precision")
    private Double precision;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @JsonProperty("Ticket")
    private String ticket;

    /**
     * 地理位置信息
     */
    @JsonProperty("Label")
    private String label;

    /**
     * 过期时间
     */
    @JsonProperty("ExpiredTime")
    @JsonSerialize(using = DateUnixTimestampSerializer.class)
    @JsonDeserialize(using = DateUnixTimestampDeserializer.class)
    private Date expiredTime;

    /**
     * 失败发生时间
     */
    @JsonProperty("FailTime")
    @JsonSerialize(using = DateUnixTimestampSerializer.class)
    @JsonDeserialize(using = DateUnixTimestampDeserializer.class)
    private Date failTime;

    /**
     * 认证失败的原因
     */
    @JsonProperty("FailReason")
    private String failReason;

    @Override
    public EventType getEventType() {
        return eventType;
    }

    /**
     * @param eventType
     *         事件类型
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     *         消息接收方
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *         消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *         消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId
     *         媒体ID
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     *         图片URL
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     *         纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public BigInteger getMsgId() {
        return msgId;
    }

    /**
     * @param msgId
     *         消息ID
     */
    public void setMsgId(BigInteger msgId) {
        this.msgId = msgId;
    }

    @Override
    public VoiceFormat getFormat() {
        return format;
    }

    /**
     * @param format
     *         语音消息格式
     */
    public void setFormat(VoiceFormat format) {
        this.format = format;
    }

    @Override
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * @param thumbMediaId
     *         视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     *         指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String getSender() {
        return sender;
    }

    /**
     * @param sender
     *         消息发送方
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *         消息描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     *         经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String getRecognition() {
        return recognition;
    }

    /**
     * @param recognition
     *         语音识别内容
     */
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String getEventKey() {
        return eventKey;
    }

    /**
     * @param eventKey
     *         事件KEY值<br>
     *         用户未关注时扫描,之后进行关注,推送类似"qrscene_123123",qrscene_为前缀,后面为二维码的参数值<br>
     *         用户已关注时扫描是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *         创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *         消息链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Double getLocationX() {
        return locationX;
    }

    /**
     * @param locationX
     *         纬度
     */
    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    @Override
    public Double getLocationY() {
        return locationY;
    }

    /**
     * @param locationY
     *         经度
     */
    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    @Override
    public Integer getScale() {
        return scale;
    }

    /**
     * @param scale
     *         地图缩放大小
     */
    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @Override
    public Double getPrecision() {
        return precision;
    }

    /**
     * @param precision
     *         地理位置精度
     */
    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    @Override
    public MsgType getMsgType() {
        return msgType;
    }

    /**
     * @param msgType
     *         消息类型
     */
    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    @Override
    public String getTicket() {
        return ticket;
    }

    /**
     * @param ticket
     *         二维码的ticket，可用来换取二维码图片
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     *         地理位置信息
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * @param expiredTime
     *         过期时间
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Override
    public Date getFailTime() {
        return failTime;
    }

    /**
     * @param failTime
     *         失败发生时间
     */
    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    @Override
    public String getFailReason() {
        return failReason;
    }

    /**
     * @param failReason
     *         认证失败的原因
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
