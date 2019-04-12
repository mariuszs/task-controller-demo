package com.example.restdemo;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void givenTasks_whenGetTaskById_thenReturnJsonMap() throws Exception {
		mvc.perform(get("/task/{id}", "001").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	@Test
	public void givenTasks_whenGetTasks_thenReturnJsonArray() throws Exception {
		mvc.perform(get("/task").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
