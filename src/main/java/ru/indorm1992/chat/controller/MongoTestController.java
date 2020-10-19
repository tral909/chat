package ru.indorm1992.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.indorm1992.chat.dao.MongoTestDao;
import ru.indorm1992.chat.dto.UserDto;
import ru.indorm1992.chat.model.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class MongoTestController {
	private final MongoTestDao mongoTestDao;

	@GetMapping
	public List<UserDto> getUsers() {
		return mongoTestDao.findAll().stream()
				.map(User::getName)
				.map(UserDto::new)
				.collect(Collectors.toList());
	}

	@PostMapping
	public void createUser(@RequestBody UserDto dto) {
		User user = new User();
		user.setName(dto.getName());
		mongoTestDao.save(user);
	}
}
