package com.jdc.online.balances.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.jdc.online.balances.model.entity.consts.BalanceType;

public class BalanceTypeConverter implements Converter<String, BalanceType>{

	@Override
	public BalanceType convert(String source) {
		
		if(StringUtils.hasLength(source)) {
			return BalanceType.from(source);
		}

		return null;
	}

}
