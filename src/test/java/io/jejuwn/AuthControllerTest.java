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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import ch.qos.logback.core.status.Status;
import io.jejuwn.controller.AddressController;
import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.controller.AuthController;
import io.jejuwn.service.AddressService;
import lombok.extern.log4j.Log4j2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AuthController.class})
@WebMvcTest
@Log4j2
public class AuthControllerTest {
	
	//@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void testGetList() throws Exception{
		postJoin();
	}
	
	String createItemForm = "";
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	void postJoin() throws Exception{
		 mvc.perform(
		            MockMvcRequestBuilders.post("/api/test/url")
		                    .contentType(MediaType.APPLICATION_JSON)
		                    .content(asJsonString(createItemForm)))
		            .andExpect(status().isCreated());
		 }

	public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
	}

}
