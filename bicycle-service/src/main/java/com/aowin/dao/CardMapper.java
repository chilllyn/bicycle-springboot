package com.aowin.dao;

import com.aowin.model.Card;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 83998
 */
@Mapper
public interface CardMapper {

	/**
	 * 根据卡编号获得卡对象
	 * @param cardCode
	 * @return
	 */
	Card getCardByCardCode(String cardCode);
}
