package me.tdd.book.Week03.ch07.repository;

import me.tdd.book.Week03.ch07.entity.User;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
