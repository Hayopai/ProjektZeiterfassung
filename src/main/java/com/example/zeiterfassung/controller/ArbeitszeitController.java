package com.example.zeiterfassung.controller;

import com.example.zeiterfassung.model.ArbeitszeitEntity;
import com.example.zeiterfassung.service.ArbeitszeitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arbeitszeit")
public class ArbeitszeitController {

    @Autowired
    private ArbeitszeitService arbeitszeitService;

    @GetMapping("/startArbeit/{userId}")
    public ResponseEntity<ArbeitszeitEntity> startArbeit(@PathVariable Long userId) {
        return ResponseEntity.ok(arbeitszeitService.startArbeit(userId));
    }

    @GetMapping("/endeArbeit/{userId}")
    public ResponseEntity<ArbeitszeitEntity> endeArbeit(@PathVariable Long userId) {
        return ResponseEntity.ok(arbeitszeitService.endeArbeit(userId));
    }

    @GetMapping("/startPause/{userId}")
    public ResponseEntity<ArbeitszeitEntity> startPause(@PathVariable Long userId) {
        return ResponseEntity.ok(arbeitszeitService.startPause(userId));
    }

    @GetMapping("/endePause/{userId}")
    public ResponseEntity<ArbeitszeitEntity> endePause(@PathVariable Long userId) {
        return ResponseEntity.ok(arbeitszeitService.endePause(userId));
    }
}



