package com.fancode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserValidationResponse {
	private String userName;
    private int userId;
    private boolean isTodoCompletionGreaterThan50Percent;

    
}
