package ru.indorm1992.chat.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.indorm1992.chat.model.User;

public interface MongoTestDao extends MongoRepository<User, String> {

}
