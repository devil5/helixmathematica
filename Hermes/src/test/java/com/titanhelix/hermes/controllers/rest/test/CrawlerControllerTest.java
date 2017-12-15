package com.titanhelix.hermes.controllers.rest.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.titanhelix.hermes.HermesApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HermesApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrawlerControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void a_verifyUrlParsing() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/crawl").accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(content().string("201")).andDo(print());
	}
	@Test
	public void z_verifyInvalidUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/crawl").param("url", "httiajs oasjdo ").accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(content().string("201")).andDo(print());
	}


}
