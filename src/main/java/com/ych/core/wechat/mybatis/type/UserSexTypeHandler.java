package com.ych.core.wechat.mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.ych.core.mybatis.type.IntValueHolderTypeHandler;
import com.ych.core.wechat.mp.UserSex;

@MappedTypes(UserSex.class)
@MappedJdbcTypes(JdbcType.NUMERIC)
public class UserSexTypeHandler extends IntValueHolderTypeHandler<UserSex> {

	public UserSexTypeHandler(Class<UserSex> type) {
		super(type);
	}


}
