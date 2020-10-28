package ru.indorm1992.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import ru.indorm1992.chat.dao.ChatMessageDao;
import ru.indorm1992.chat.dto.ChatMessageDto;
import ru.indorm1992.chat.mapper.ChatMessageMapper;
import ru.indorm1992.chat.model.ChatMessage;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {
	private final ChatMessageDao    chatMessageDao;
	private final ChatMessageMapper chatMessageMapper;

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessageDto sendMessage(@Payload ChatMessageDto dto) {
		chatMessageDao.save(chatMessageMapper.toModel(dto));
		return dto;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessageDto addUser(@Payload ChatMessageDto dto, SimpMessageHeaderAccessor headerAccessor) {
		Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
		Assert.notNull(sessionAttributes, "sessionAttributes is null");
		chatMessageDao.save(chatMessageMapper.toModel(dto));

		// Добавим имя пользователя в сессию веб сокета
		sessionAttributes.put("username", dto.getSender());
		return dto;
	}
}
