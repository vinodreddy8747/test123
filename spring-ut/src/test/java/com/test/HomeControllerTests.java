package com.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
/*** In this the whole spring application context is started but without the server**/
//@SpringBootTest
//@AutoConfigureMockMvc
/*** In this case Spring boot is only instantiating the Web layer**/
//@WebMvcTest
/*** We can still initialize the one controller to instantiated ***/
@WebMvcTest(HomeController.class)
public class HomeControllerTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	public void getHelloShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
	}
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/hi")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hi, World!")));
	}
}
