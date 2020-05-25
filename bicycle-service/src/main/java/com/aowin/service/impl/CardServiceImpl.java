package com.aowin.service.impl;

import com.aowin.dao.CardMapper;
import com.aowin.model.Card;
import com.aowin.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 83998
 */
@Service
public class CardServiceImpl implements CardService {

	@Resource
	CardMapper cardMapper;

	@Override
	public Card getCardByCardCode(String cardCode) {
		return cardMapper.getCardByCardCode(cardCode);
	}

}
