package ru.indorm1992.chat.dto;

import lombok.Value;

@Value
public class ChatMessageDto {
	MessageType type;
	String content;
	String sender;

	public enum MessageType {
		CHAT, JOIN, LEAVE
	}
}
