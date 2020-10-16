package ru.indorm1992.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import ru.indorm1992.chat.dto.ChatMessageDto;

import java.util.Map;

@Controller
public class ChatController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessageDto sendMessage(@Payload ChatMessageDto dto) {
		return dto;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessageDto addUser(@Payload ChatMessageDto dto, SimpMessageHeaderAccessor headerAccessor) {
		Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
		Assert.notNull(sessionAttributes, "sessionAttributes is null");

		// Добавим имя пользователя в сессию веб сокета
		sessionAttributes.put("username", dto.getSender());
		return dto;
	}
}
