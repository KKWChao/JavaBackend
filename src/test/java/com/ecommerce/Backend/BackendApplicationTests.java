package com.ecommerce.Backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.catalina.core.ApplicationContext;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.Backend.controller.BackendController;
import com.ecommerce.Backend.entity.Account;
import com.ecommerce.Backend.service.AccountService;

@SpringBootTest
class BackendApplicationTests {

	@Mock
	private AccountService accountService;

	@InjectMocks
	private BackendController backendController;

	@Test
	void twoPlusTwoEqualsFour() {
		assertEquals(1, 1);
	}
}
