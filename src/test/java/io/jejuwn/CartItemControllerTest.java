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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.jejuwn.controller.CartItemController;
import io.jejuwn.mapper.CartItemMapper;
import io.jejuwn.service.CartItemService;
import lombok.extern.log4j.Log4j2;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {CartItemController.class, CartItemService.class, CartItemMapper.class})
@WebMvcTest
@Log4j2
public class CartItemControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CartItemService service;
	
	@DisplayName("카트 아이템 삭제")
	@Test
	public void deleteCartItemTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.
							delete("/cartitem/{id}", 1L)
							.contentType(MediaType.APPLICATION_JSON))
							.andDo(print())
							.andExpect(status().isOk())
							.andReturn();
		
		String resultController = result.getResponse().getContentAsString();
		assertNotNull(resultController);
		log.info(resultController);
		
	}

		
}
