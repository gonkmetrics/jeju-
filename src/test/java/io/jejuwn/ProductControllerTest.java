package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import io.jejuwn.controller.ProductController;
import io.jejuwn.mapper.ProductMapper;
import io.jejuwn.repository.ProductRepository;
import io.jejuwn.service.ProductService;
import lombok.extern.log4j.Log4j2;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ProductController.class, ProductService.class, ProductMapper.class})
@WebMvcTest
@Log4j2
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ProductRepository repository;
	
	@MockBean
	private ProductService service;
	
	 @Test
	    public void getProduct() throws Exception {
			MvcResult result = mvc.perform(MockMvcRequestBuilders
					.get("/product/list", 1)
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();
		 
			String resultController = result.getResponse().getContentAsString();
			assertNotNull(resultController);
			log.info(resultController);
	    }
}
