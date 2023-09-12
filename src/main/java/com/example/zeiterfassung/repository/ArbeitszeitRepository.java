package com.example.zeiterfassung.repository;

import com.example.zeiterfassung.model.ArbeitszeitEntity;
import com.example.zeiterfassung.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArbeitszeitRepository extends JpaRepository<ArbeitszeitEntity, Long> {

    // Beispiel für eine benutzerdefinierte Abfrage:
    List<ArbeitszeitEntity> findByUser(UsersModel user);

    Optional<ArbeitszeitEntity> findByUserId(Long userId);
}
