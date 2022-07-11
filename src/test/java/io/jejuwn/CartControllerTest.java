package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jejuwn.controller.CartController;
import io.jejuwn.mapper.CartMapper;
import io.jejuwn.model.Cart;
import io.jejuwn.service.CartService;
import lombok.extern.log4j.Log4j2;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {CartController.class, CartService.class, CartMapper.class})
@WebMvcTest(CartController.class)
@Log4j2
public class CartControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	
	@DisplayName("cart Test for http Request") //단위테스트를 명시해주기 위한 Annotaion
	@Test
	void cartInsetTest() throws Exception{
		
		//given...
		Cart cart = new Cart();
		cart.setId(BigDecimal.valueOf(2));
		cart.setToken(BigDecimal.valueOf(3));
		cart.setUserId(BigDecimal.valueOf(1));
		
		mvc.perform(MockMvcRequestBuilders
				.post("/cart")
				.contentType(MediaType.APPLICATION_JSON))
				.content()
				.accept(MediaType.APPLICATION_JSON)
				.andExpect(status().isOk())
				.andReturn();
		
		String resultController = result.getResponse().getContentAsString();
		assertNotNull(resultController);
		log.info(resultController);
	}
}
