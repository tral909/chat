package ru.indorm1992.chat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("test_user")
public class User {
	@Id
	String id;
	String name;
}
