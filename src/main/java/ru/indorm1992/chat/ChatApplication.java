package ru.indorm1992.chat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	/**
	 * Не работает...
	 *
	 * Чтобы избежать @JsonCreator и @JsonProperty или @ConstructorProperties
	 * <br>над явным контруктором при десериализации в ДТО. Надо:
	 * 1) JDK 1.8
	 * 2) compile with -parameters argument (см options в build.gradle)
	 * 3) use and register jackson-module-parameter-names (это ниже)
	 */
//	@Bean
//	public ObjectMapper objectMapper() {
//		ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
//		mapper.registerModule(new ParameterNamesModule());
//		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//		return mapper;
//	}
}
