package com.example.zeiterfassung.repository;

import com.example.zeiterfassung.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByLoginAndPassword(String login, String password);

    Optional<UsersModel> findFirstByLogin(String login);

    UsersModel findUserById(Long id);
}