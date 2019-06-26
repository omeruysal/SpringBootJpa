package com.example.demo;

import java.net.URI;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {

	private RestTemplate restTemplate;
		
	@Before 			//setup methodları her test methodları 
	public void setup() { //calısmadan calısır ve ıcındekı kodu execute eder
		restTemplate = new  RestTemplate();
	}
	

}
