package com.aowin.service;

import com.aowin.model.Card;

/**
 * @author 83998
 */
public interface CardService {

	/**
	 * 根据cardCode获取card
	 * @Author Chill_Lyn
	 * @Description 根据cardCode获取card
	 * @Date 2020/5/25 21:25
	 * @Param [cardCode]
	 * @return com.aowin.model.Card
	 **/
	Card getCardByCardCode(String cardCode);
}
