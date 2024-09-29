package com.fancode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fancode.model.Todo;
import com.fancode.model.User;
import com.fancode.model.UserValidationResponse;
@Component
public class UserValidationBL {
	@Autowired
	private TodoService todoService;

	public List<User> getFancodeUsers() {
		return todoService.getAllUsers().stream().filter(user -> {
			double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
			double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
			return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
		}).collect(Collectors.toList());
	}

	public boolean isTodoCompletionGreaterThan50Percent(int userId) {
		List<Todo> todos = todoService.getTodosByUserId(userId);
		long completedCount = todos.stream().filter(Todo::isCompleted).count();
		return completedCount > todos.size() / 2;
	}
	
	
	public List<UserValidationResponse> validateFancodeUsers() {
	    List<User> fancodeUsers = getFancodeUsers();
	    List<UserValidationResponse> validationResults = new ArrayList<>();

	    for (User user : fancodeUsers) {
	        boolean isCompletedMoreThan50 = isTodoCompletionGreaterThan50Percent(user.getId());
	        validationResults.add(new UserValidationResponse(user.getName(), user.getId(), isCompletedMoreThan50));
	    }
	    return validationResults;
	}
}
