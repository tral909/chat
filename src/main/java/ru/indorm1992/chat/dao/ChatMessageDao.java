package ru.indorm1992.chat.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.indorm1992.chat.model.ChatMessage;

public interface ChatMessageDao extends MongoRepository<ChatMessage, String> {
}
