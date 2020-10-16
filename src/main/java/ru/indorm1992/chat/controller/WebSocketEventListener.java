package ru.indorm1992.chat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import ru.indorm1992.chat.dto.ChatMessageDto;

import java.util.Map;

@Slf4j
@Component
public class WebSocketEventListener {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		log.info("Recieved a new web socket connection");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
		Assert.notNull(sessionAttributes, "sessionAttributes is null");

		String username = (String) sessionAttributes.get("username");
		if (username != null) {
			log.info("User disconnected: " + username);
			ChatMessageDto dto = new ChatMessageDto(
					ChatMessageDto.MessageType.LEAVE,
					null,
					username
			);
			messagingTemplate.convertAndSend("/topic/public", dto);
		}
	}
}
