package ru.indorm1992.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.indorm1992.chat.dto.ChatMessageDto;
import ru.indorm1992.chat.model.ChatMessage;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

	@Mapping(target = "id", ignore = true)
	ChatMessage toModel(ChatMessageDto dto);
}
