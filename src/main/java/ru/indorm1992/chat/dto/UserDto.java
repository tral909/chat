package ru.indorm1992.chat.dto;

import lombok.Value;

import java.beans.ConstructorProperties;

@Value
public class UserDto {
	String name;

	@ConstructorProperties({"name"})
	public UserDto(String name) {
		this.name = name;
	}
}
