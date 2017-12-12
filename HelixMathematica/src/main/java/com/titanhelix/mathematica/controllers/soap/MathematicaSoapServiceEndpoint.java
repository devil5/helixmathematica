package com.titanhelix.mathematica.controllers.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.titanhelix.mathematica.MathematicaConstants;
import com.titanhelix.mathematica.services.GcdNumbersService;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdListRequest;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdListResponse;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdRequest;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdResponse;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdSumRequest;
import com.titanhelix.mathematica.ws.mathematica_soap.GetGcdSumResponse;

@Endpoint
public class MathematicaSoapServiceEndpoint {

	@Autowired
	private GcdNumbersService gcdNumbersService;

	@PayloadRoot(namespace = MathematicaConstants.NAMESPACE_URI, localPart = "getGcdRequest")
	@ResponsePayload
	public GetGcdResponse getGcd(@RequestPayload GetGcdRequest request) {
		GetGcdResponse response = new GetGcdResponse();
		response.setGcd(gcdNumbersService.getGcd());
		return response;
	}

	@PayloadRoot(namespace = MathematicaConstants.NAMESPACE_URI, localPart = "getGcdSumRequest")
	@ResponsePayload
	public GetGcdSumResponse getGcdSum(@RequestPayload GetGcdSumRequest request) {
		GetGcdSumResponse response = new GetGcdSumResponse();
		response.setGcdSum(gcdNumbersService.getGcdSum());
		return response;
	}

	@PayloadRoot(namespace = MathematicaConstants.NAMESPACE_URI, localPart = "getGcdListRequest")
	@ResponsePayload
	public GetGcdListResponse getGcdList(@RequestPayload GetGcdListRequest request) {
		GetGcdListResponse response = new GetGcdListResponse();
		response.getGcdList().addAll(gcdNumbersService.getGcdList());
		return response;
	}

}