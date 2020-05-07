package com.aowin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Card;
import com.aowin.service.CardService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/card")
public class CardContoller {

	@Resource
	private CardService cardServiceImpl;

	@RequestMapping(value = "/getCardByCardCode", method = { RequestMethod.POST }, produces = {
	        "application/json;charset=utf-8" })
	public Card getCardByCardCode(Card card) {
		return cardServiceImpl.getCardByCardCode(card.getCardCode());
	}
}
