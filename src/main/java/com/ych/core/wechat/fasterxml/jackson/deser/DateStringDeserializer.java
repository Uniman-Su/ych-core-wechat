package com.ych.core.wechat.fasterxml.jackson.deser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ych.core.wechat.pay.Constants;

/**
 * 将字符串时间戳转换为Date对象
 * <p>
 * Created by U on 2017/6/30.
 */
public class DateStringDeserializer extends StdDeserializer<Date> {

    /**
     * 构造方法
     */
    public DateStringDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        switch (p.getCurrentTokenId()) {
            case JsonTokenId.ID_STRING:
                // let's allow Strings to be converted too
                // !!! 05-Jan-2009, tatu: Should we try to limit value space, JDK is too lenient?
                String text = p.getText().trim();

                if (StringUtils.isBlank(text)) {
                    return null;
                }

                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                format.setTimeZone(Constants.WECHAT_SERVER_TIMEZONE);

                try {
                    return format.parse(text);
                } catch (ParseException e) {

                }
                return (Date) ctxt.handleWeirdStringValue(_valueClass, text,
                        "not a valid Unix timestamp value");

            case JsonTokenId.ID_NULL:
                return null;

            default:
                return (Date) ctxt.handleUnexpectedToken(_valueClass, p);
        }
    }
}
