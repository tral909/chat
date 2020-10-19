package ru.indorm1992.chat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
	@Id
	String id;
	String name;
}
