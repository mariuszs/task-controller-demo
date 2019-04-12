package com.example.restdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/task")
public class TaskController {

	public static void main(String[] args) {
		SpringApplication.run(TaskController.class, args);
	}

	@GetMapping
	public ResponseEntity<List<Task>> getTasks() {
		return new ResponseEntity<>(Arrays.asList(new Task(), new Task()), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> getTaskById(@PathVariable String id) {
		return new ResponseEntity<>(new Task(), HttpStatus.OK);
	}

	public class Task {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}