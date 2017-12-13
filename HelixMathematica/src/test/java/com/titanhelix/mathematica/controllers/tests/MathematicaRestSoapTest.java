package com.titanhelix.mathematica.controllers.tests;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.titanhelix.mathematica.HelixMathematicaApplication;
import com.titanhelix.mathematica.controllers.soap.MathematicaSoapServiceEndpoint;
import com.titanhelix.mathematica.ws.mathematica.GetGcdListRequest;
import com.titanhelix.mathematica.ws.mathematica.GetGcdListResponse;
import com.titanhelix.mathematica.ws.mathematica.GetGcdRequest;
import com.titanhelix.mathematica.ws.mathematica.GetGcdResponse;
import com.titanhelix.mathematica.ws.mathematica.GetGcdSumRequest;
import com.titanhelix.mathematica.ws.mathematica.GetGcdSumResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelixMathematicaApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MathematicaRestSoapTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private MathematicaSoapServiceEndpoint mathematicaSoapServiceEndpoint;

	/*
	 * Integration Testing REST/SOAP API - alphabetical prefixes are to ensure order
	 */
	@Test
	public void a_verifyEmptyList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/list").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}

	@Test
	public void ba_verifyValidRestPush() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/3/6").accept(MediaType.TEXT_PLAIN)).andExpect(status().isCreated()).andExpect(content().string("201")).andDo(print());
	}

	@Test
	public void bc_verifyValidRestPush() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/10/5").accept(MediaType.TEXT_PLAIN)).andExpect(status().isCreated()).andExpect(content().string("201")).andDo(print());
	}

	@Test
	public void c_verifyPopulatedList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/list").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}

	@Test
	public void cc_getGcd() throws Exception {
		GetGcdRequest getGcdRequest = new GetGcdRequest();
		GetGcdResponse getGcdResponse = mathematicaSoapServiceEndpoint.getGcd(getGcdRequest);
		Assert.assertNotNull(getGcdResponse);
		Assert.assertEquals(5, getGcdResponse.getGcd());
	}

	@Test
	public void cd_getGcdList() throws Exception {
		GetGcdListRequest getGcdListRequest = new GetGcdListRequest();
		GetGcdListResponse getGcdListResponse = mathematicaSoapServiceEndpoint.getGcdList(getGcdListRequest);
		Assert.assertNotNull(getGcdListResponse);
		Assert.assertTrue(getGcdListResponse.getGcdList().size() > 0);
		Assert.assertTrue(Integer.valueOf(getGcdListResponse.getGcdList().get(0)) == 5);
	}

	@Test
	public void ce_getGcdSum() throws Exception {
		GetGcdSumRequest getGcdSumRequest = new GetGcdSumRequest();
		GetGcdSumResponse getGcdSumResponse = mathematicaSoapServiceEndpoint.getGcdSum(getGcdSumRequest);
		Assert.assertNotNull(getGcdSumResponse);
		Assert.assertTrue(getGcdSumResponse.getGcdSum() == 5);
	}

	@Test
	public void d_verifyValidRestPush2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/21/14").accept(MediaType.TEXT_PLAIN)).andExpect(status().isCreated()).andExpect(content().string("201")).andDo(print());
	}

	@Test
	public void da_getGcd() throws Exception {
		GetGcdRequest getGcdRequest = new GetGcdRequest();
		GetGcdResponse getGcdResponse = mathematicaSoapServiceEndpoint.getGcd(getGcdRequest);
		Assert.assertNotNull(getGcdResponse);
		Assert.assertEquals(7, getGcdResponse.getGcd());
	}

	@Test
	public void db_getGcdList() throws Exception {
		GetGcdListRequest getGcdListRequest = new GetGcdListRequest();
		GetGcdListResponse getGcdListResponse = mathematicaSoapServiceEndpoint.getGcdList(getGcdListRequest);
		Assert.assertNotNull(getGcdListResponse);
		Assert.assertTrue(getGcdListResponse.getGcdList().size() > 0);
		Assert.assertTrue(Integer.valueOf(getGcdListResponse.getGcdList().get(1)) == 7);
	}

	@Test
	public void dc_getGcdSum() throws Exception {
		GetGcdSumRequest getGcdSumRequest = new GetGcdSumRequest();
		GetGcdSumResponse getGcdSumResponse = mathematicaSoapServiceEndpoint.getGcdSum(getGcdSumRequest);
		Assert.assertNotNull(getGcdSumResponse);
		Assert.assertTrue(getGcdSumResponse.getGcdSum() == 12);
	}

	@Test
	public void ea_verifyInvalidDecimalRestPush() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/53.523/95..5").accept(MediaType.TEXT_PLAIN)).andExpect(status().isBadRequest()).andExpect(content().string("400")).andDo(print());
	}

	@Test
	public void eb_verifyPopulatedList2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/list").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(6))).andDo(print());
	}

	@Test
	public void f_verifyInvalidEmptyRestPush() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push//").accept(MediaType.TEXT_PLAIN)).andExpect(status().isNotFound()).andExpect(content().string("")).andDo(print());
	}

	@Test
	public void g_verifyInvalidDecimalRestPush() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/3.5/6.5").accept(MediaType.TEXT_PLAIN)).andExpect(status().isBadRequest()).andExpect(content().string("400")).andDo(print());
	}

	// TODO: Investigate overriding behaviour of @Rest advice - Momin
	// @Test
	// public void h_verifyInvalidLongIntegerRestPush() throws Exception {
	// mockMvc.perform(MockMvcRequestBuilders.post("/rest/push/355555555555555555555555555555555555/65555555555555555555555555555555555555555555").accept(MediaType.TEXT_PLAIN)).andExpect(content().string("400")).andDo(print());
	// }

}