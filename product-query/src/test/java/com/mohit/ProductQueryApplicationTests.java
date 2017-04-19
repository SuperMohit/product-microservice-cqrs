package com.mohit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohit.api.ProductQueryAPI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductQueryApplicationTests {

	@Autowired
	private ProductQueryAPI productQueryAPI;
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private ConcurrentMap<String, AtomicLong> productCatalog;

	@Before
	public void setProductCatalog() {
		
		productCatalog.put("Product1", new AtomicLong(1000));
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(productQueryAPI).isNotNull();
	}

	@Test
	public void fetchProducts() throws Exception {
		ConcurrentMap<String, AtomicLong> productCatalog = this.restTemplate
				.getForObject("http://localhost:" + port + "/", ConcurrentMap.class);

		assertThat(productCatalog.containsKey("Product1"));

	}

}
