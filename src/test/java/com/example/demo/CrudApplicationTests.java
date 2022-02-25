package com.example.demo;
import com.jayway.jsonpath.JsonPath;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CrudApplicationTests {

	private MockMvc mockmvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@BeforeEach
	private void setUp(){
		mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	void checkJsonFormat() throws Exception {
		System.out.println("aaaa");
		mockmvc.perform(MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("[0].nome_utente").hasJsonPath());



	}
	@Test
	void contextLoads() {
	}

}
