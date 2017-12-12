package com.titanhelix.mathematica.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titanhelix.mathematica.services.GcdNumbersService;

@RestController
@RequestMapping(value = "rest")
public class MathematicaRest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private GcdNumbersService gcdNumbersService;

	// Returns HTTP status response as a String - According to specifications
	@RequestMapping(method = RequestMethod.POST, value = "/push/{i1}/{i2}", produces = "text/plain")
	public String push(HttpServletResponse httpServletResponse, @PathVariable String i1, @PathVariable String i2) {
		if ((StringUtils.isNumeric(i1)) && (StringUtils.isNumeric(i2))) {
			jmsTemplate.convertAndSend("GcdNumbersService", i1);
			jmsTemplate.convertAndSend("GcdNumbersService", i2);

			httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
			return HttpStatus.CREATED.toString();
		}

		httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return HttpStatus.BAD_REQUEST.toString();
	}

	// Explicit produces to application/json not required - precautionary
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = "application/json")
	public List<Integer> list() {
		return gcdNumbersService.getAllNumbers();
	}

}
