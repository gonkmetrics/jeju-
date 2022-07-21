package io.jejuwn.controller;

import java.math.BigDecimal;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.jejuwn.model.PaymentRequest;
import io.jejuwn.model.ProductComment;
import io.jejuwn.model.UserOrder;
import io.jejuwn.service.PaymentServiceImpl;
import io.jejuwn.service.UserOrderService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentService;
	
	@Autowired
	private UserOrderService uos;
	
	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5);
	
	@PostMapping(value="/complete", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> paymentsComplete(
		@RequestBody PaymentRequest request){
		
		String paymentAmount = paymentService.getPaymentData(request.getImpUid());
		int total = paymentService.getOrderAmount(request.getCartId().intValue());
		
		if(total==Integer.parseInt(paymentAmount)) {
			UserOrder uo = new UserOrder(
					null, null, request.getUserId(), request.getCartId(), request.getAddressId(), 1L, null, request.getImpUid());
			uos.userOrderInsert(uo);
		}
		
		ResponseEntity<String> entity = null;
		try {
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
		entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
}

}
