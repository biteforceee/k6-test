package com.storage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "test_data")
public class StorageData {
    @Id
    private UUID id;
    public StorageData() {
        this.id = UUID.randomUUID(); // Генерируем в конструкторе
    }
}
