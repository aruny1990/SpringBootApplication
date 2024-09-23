package com.RegistrationApp.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import com.RegistrationApp.demo.Application;
import com.RegistrationApp.demo.service.UserService;

import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
@SpringBootTest(classes = Application.class) // Load the full application context
@ComponentScan("com.RegistrationApp.demo.service") // Adjust if needed
@AutoConfigureMockMvc // Enable MockMvc

public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private UserService userService;  
	@WithMockUser(username = "admin", roles = "ADMIN")  // Use appropriate role
    @Test
    public void testRegisterUser() throws Exception {
		mockMvc.perform(post("/api/register")
	            .with(csrf())  // Add CSRF token if necessary
	            .contentType(MediaType.APPLICATION_JSON)
	            .content("{ \"username\": \"testUser\", \"password\": \"password123\" }"))
	            .andExpect(status().isOk());  // Expect 200 OK
   }
}
