package com.aowin.service;

import com.aowin.model.Card;

public interface CardService {

	/**
	 * 根据cardCode获取card
	 * @param cardCode
	 * @param cardType
	 * @return
	 */
	Card getCardByCardCode(String cardCode);
}
