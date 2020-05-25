package com.aowin.listener;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.concurrent.TimeUnit;

/**
 * @author 83998
 */
@Component
public class SendCodeListener{

	@Resource
	private StringRedisTemplate stringRedisTemlate;

	@JmsListener(destination="${spring.activemq.queue-name}", containerFactory="queueListener")
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			String mobilePhone = msg.getText();
			String verificationCode = (int) ((Math.random() * 9 + 1) * 1000) + "";
			stringRedisTemlate.opsForValue().set(mobilePhone, verificationCode, 10, TimeUnit.MINUTES);
			System.out.println(mobilePhone + ":" + verificationCode);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
