package ru.indorm1992.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //включает Websocket сервер
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// регистрируем конечную точку, которую клиенты будут использовать,
		// чтобы подключиться к нашему Websocket-серверу
		// SockJS – для браузеров, которые не поддерживают Websocket.
		registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// сообщения, чей адрес (куда отправлены) начинается с  “/app“,
		// должны быть направлены в методы (аннотированные @MessageMapping),
		// занимающиеся обработкой сообщений.
		registry.setApplicationDestinationPrefixes("/app");
		// сообщения, чей адрес начинается с  “/topic“,
		// должны быть направлены в брокер сообщений
		registry.enableSimpleBroker("/topic");
	}
}
