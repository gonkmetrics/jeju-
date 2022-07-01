package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import ch.qos.logback.core.status.Status;
import io.jejuwn.controller.AddressController;
import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.service.AddressService;
import lombok.extern.log4j.Log4j2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AddressController.class})
@ComponentScan({"io.jejuwn.service"})
@WebMvcTest
@Log4j2
public class AddressControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void testGetList() throws Exception{
		getList();
	}
	
	void getList() throws Exception{
		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/address/list")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		String resultController = result.getResponse().getContentAsString();
		assertNotNull(resultController);
		log.info(resultController);
	}

}
