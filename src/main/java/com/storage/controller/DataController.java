package com.storage.controller;


import com.storage.model.StorageData;
import com.storage.storage.DataStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/insert")
public class DataController {

    @Autowired
    private DataStorage dataStorage;

    @PostMapping
    public ResponseEntity<String> post() {
        try {
            //log.info("=== Creating new record ===");

            // Создаем новую запись - ID сгенерируется автоматически
            StorageData data = new StorageData();
            StorageData savedData = dataStorage.save(data);

            //log.info("=== Record saved with UUID: {} ===", savedData.getId());

            return ResponseEntity.ok("UUID inserted: " + savedData.getId());

        } catch (Exception e) {
            //log.error("=== Error saving data ===", e);
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getMessage());
        }
    }
}
