package io.jejuwn;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jejuwn.controller.CartController;
import io.jejuwn.mapper.CartMapper;
import io.jejuwn.model.Cart;
import io.jejuwn.service.CartService;
import lombok.extern.log4j.Log4j2;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebMvcTest(CartController.class)
@Log4j2
public class CartControllerTest {
	
	@MockBean
	CartService cartService;
	
	@Autowired
	private MockMvc mvc;
	ObjectMapper mapper; 
	
	@Autowired
	CartController cartController;
	
	
	@DisplayName("cart Test for http Request") //단위테스트를 명시해주기 위한 Annotaion
	@Test
	public void cartInsetTest() throws Exception{
	    	
	/* Cart cart = Cart.builder()
			.id(1L)
			.token(1L)
			.userId(1L)
			.bulid(); */
}
}