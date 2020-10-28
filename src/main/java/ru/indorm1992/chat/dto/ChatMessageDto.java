package ru.indorm1992.chat.dto;

import lombok.Value;
import ru.indorm1992.chat.model.MessageType;

import java.beans.ConstructorProperties;

@Value
public class ChatMessageDto {
	MessageType type;
	String content;
	String sender;

	@ConstructorProperties({"name", "content", "sender"})
	public ChatMessageDto(MessageType type,
						  String content,
						  String sender) {
		this.type = type;
		this.content = content;
		this.sender = sender;
	}
}
