package com.hotel.pets.repository;

import com.hotel.pets.model.entity.QuestionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionUserRepository extends JpaRepository<QuestionUser, Long> {
}
