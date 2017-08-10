package com.ych.core.wechat.mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.ych.core.mybatis.type.IntValueHolderTypeHandler;
import com.ych.core.wechat.mp.authorization.AuthorizationScope;

@MappedTypes(AuthorizationScope.class)
@MappedJdbcTypes(JdbcType.NUMERIC)
public class AuthorizationScopeTypeHandler extends IntValueHolderTypeHandler<AuthorizationScope> {

	public AuthorizationScopeTypeHandler(Class<AuthorizationScope> type) {
		super(type);
	}


}
