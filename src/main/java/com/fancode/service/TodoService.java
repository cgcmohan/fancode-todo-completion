package com.fancode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fancode.configuration.ApiConfig;
import com.fancode.model.Todo;
import com.fancode.model.User;

@Service
public class TodoService {

    private final WebClient webClient;

    private final ApiConfig apiConfig;
    
	@Autowired
	public TodoService(WebClient webClient, ApiConfig apiConfig) {
		this.webClient = webClient;
		this.apiConfig = apiConfig;
	}

	public List<User> getAllUsers() {
		List<User> users = webClient//
				.get()//
				.uri(apiConfig.getEndpoints().getUsers())//
				.retrieve()//
				.bodyToFlux(User.class)//
				.collectList()//
				.block();
		return users;
	}

	public List<Todo> getTodosByUserId(int userId) {
		List<Todo> todos = webClient//
				.get()//
				.uri(apiConfig.getEndpoints().getTodos() + userId)//
				.retrieve()//
				.bodyToFlux(Todo.class)//
				.collectList()//
				.block();
		return todos;
	}
}
