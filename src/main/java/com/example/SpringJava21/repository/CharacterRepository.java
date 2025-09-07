package com.example.SpringJava21.repository;

import com.example.SpringJava21.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
