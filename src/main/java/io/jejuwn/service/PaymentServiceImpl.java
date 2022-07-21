package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import io.jejuwn.model.CartItem;
import io.jejuwn.model.Product;
import io.jejuwn.model.ProductInfo;
import io.jejuwn.repository.ProductInfoRepository;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class PaymentServiceImpl {
	
	@Autowired
	CartItemService cartItemService;
	
	//get payment and order id
	private String getToken() {
		WebClient requestToken = WebClient.builder().baseUrl("https://api.iamport.kr").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		UriSpec<RequestBodySpec> uriSpec = requestToken.method(HttpMethod.POST);
		RequestBodySpec bodySpec = uriSpec.uri("/users/getToken");
		
		//to json
		Map<String, String> bodyMap = new HashMap();
		bodyMap.put("imp_apikey", "GET KEY AFTER REG");
		bodyMap.put("imp_secret", "GET SECRET AFTER REG");
		
		RequestHeadersSpec<?> headersSpec = bodySpec.body(BodyInserters.fromValue(bodyMap));
		//ResponseSpec responseSpec = headersSpec.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).accept().retrieve();
		Mono<String> response = headersSpec.retrieve().bodyToMono(String.class);
		log.info(response);
		String responseString = response.block();
		return responseString;
		
		
	}
	
	//get payment amount from imp server
	public String getPaymentData(String impUid) {
		WebClient requestToken = WebClient.builder().baseUrl("https://api.iamport.kr").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		UriSpec<RequestBodySpec> uriSpec = requestToken.method(HttpMethod.GET);
		RequestBodySpec bodySpec = uriSpec.uri("/payments/"+impUid);
		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("");
		String impBearer = getToken();
		Mono<String> response = headersSpec.headers(header -> header.setBearerAuth(impBearer)).retrieve().bodyToMono(String.class);
		String responseString = response.block();
		return responseString;
	}
	
	//get original amount from database: jpa get sum of cols in table cart n
	public int getOrderAmount(int CartId) {
		List<CartItem> cItem = cartItemService.getAllCartItemByCartId((long) CartId);
		
		int sum = 0;
		Long price = 0L;
		for(CartItem item: cItem) {
			price = item.getPrice();
			sum += price;
		}
		
		return sum;
		
	}
	
	//verify payment amount

}
