package com.example.zeiterfassung.service;

import com.example.zeiterfassung.model.ArbeitszeitEntity;
import com.example.zeiterfassung.repository.ArbeitszeitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ArbeitszeitService {

    @Autowired
    private ArbeitszeitRepository arbeitszeitRepository;

    public ArbeitszeitEntity startArbeit(Long userId) {
        ArbeitszeitEntity arbeitszeit = arbeitszeitRepository.findByUserId(userId).orElse(new ArbeitszeitEntity());
        arbeitszeit.setId(userId);
        arbeitszeit.setArbeitsDatum(LocalDate.now()); // Setzen des heutigen Datums
        arbeitszeit.setArbeitBeginn(LocalDateTime.now());
        return arbeitszeitRepository.save(arbeitszeit);
    }

    public ArbeitszeitEntity endeArbeit(Long userId) {
        ArbeitszeitEntity arbeitszeit = arbeitszeitRepository.findByUserId(userId).orElse(null);
        if (arbeitszeit != null) {
            arbeitszeit.setArbeitEnde(LocalDateTime.now());
            return arbeitszeitRepository.save(arbeitszeit);
        }
        return null;
    }

    public ArbeitszeitEntity startPause(Long userId) {
        ArbeitszeitEntity arbeitszeit = arbeitszeitRepository.findByUserId(userId).orElse(null);
        if (arbeitszeit != null) {
            arbeitszeit.setPauseBeginn(LocalDateTime.now());
            return arbeitszeitRepository.save(arbeitszeit);
        }
        return null;
    }

    public ArbeitszeitEntity endePause(Long userId) {
        ArbeitszeitEntity arbeitszeit = arbeitszeitRepository.findByUserId(userId).orElse(null);
        if (arbeitszeit != null) {
            arbeitszeit.setPauseEnde(LocalDateTime.now());
            return arbeitszeitRepository.save(arbeitszeit);
        }
        return null;
    }
}
