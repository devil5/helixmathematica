package com.titanhelix.mathematica.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.titanhelix.mathematica.data.IntegerQueue;

@Component
public class IntegerReceiver {

	@Autowired
	private IntegerQueue integerQueue;

	@JmsListener(destination = "IntegerQueue", containerFactory = "jmsListenerFactory")
	public void receiveMessage(Integer number) {
		integerQueue.save(number);
	}

}
