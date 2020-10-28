package ru.indorm1992.chat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("chat_message")
public class ChatMessage {
	@Id
	String id;
	MessageType type;
	String content;
	String sender;
}
