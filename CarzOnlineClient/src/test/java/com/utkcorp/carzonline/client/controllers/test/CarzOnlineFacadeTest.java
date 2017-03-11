package com.utkcorp.carzonline.client.controllers.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servletConfig.xml"})
@WebAppConfiguration
public class CarzOnlineFacadeTest {
	
	@Autowired WebApplicationContext wac; 
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

	@Test
	public void checkLoginPageAvailable() throws Exception {
		mockMvc.perform(post("/login")).andExpect(status().isOk()).andExpect(view().name("basic/login"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/basic/login.jsp"));
	}
	
	@Test
	public void checkLoginFailurePageAvailable() throws Exception {
		mockMvc.perform(post("/loginFailure")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/login"));
	}
	
	@Test
	public void checkLogoutPageAvailable() throws Exception {
		mockMvc.perform(post("/logout")).andExpect(status().isOk()).andExpect(view().name("basic/logout"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/basic/logout.jsp"));
	}
	
	@Test
	public void checkHomepageAvailable() throws Exception {
		mockMvc.perform(post("/homepage")).andExpect(status().isOk()).andExpect(view().name("basic/homepage"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/basic/homepage.jsp"));
	}
	
	@Test
	public void checkServiceDeniedPageAvailable() throws Exception {
		mockMvc.perform(post("/serviceDenied")).andExpect(status().isOk()).andExpect(view().name("basic/serviceDenied"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/basic/serviceDenied.jsp"));
	}
}
