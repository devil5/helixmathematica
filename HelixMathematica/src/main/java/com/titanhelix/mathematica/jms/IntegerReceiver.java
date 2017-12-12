package com.titanhelix.mathematica.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.titanhelix.mathematica.services.GcdNumbersService;

@Component
public class IntegerReceiver {

	@Autowired
	private GcdNumbersService gcdNumbersService;

	@JmsListener(destination = "GcdNumbersService", containerFactory = "jmsListenerFactory")
	public void receiveMessage(Integer number) {
		gcdNumbersService.save(number);
	}

}
