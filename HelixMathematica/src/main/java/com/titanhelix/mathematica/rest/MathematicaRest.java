package com.titanhelix.mathematica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titanhelix.mathematica.data.IntegerQueue;

@RestController
@RequestMapping(value = "rest")
public class MathematicaRest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private IntegerQueue integerQueue;

	@RequestMapping(method = RequestMethod.POST, value = "/push/{i1}/{i2}", produces = "text/plain")
	public String push(@PathVariable Integer i1, @PathVariable Integer i2) {
		jmsTemplate.convertAndSend("IntegerQueue", i1);
		jmsTemplate.convertAndSend("IntegerQueue", i2);

		return "SUCCESS";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = "application/json")
	public List<Integer> list() {
		return integerQueue.getAllNumbers();
	}

}
