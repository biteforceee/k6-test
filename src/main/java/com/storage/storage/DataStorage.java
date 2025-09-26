package com.storage.storage;

import com.storage.model.StorageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DataStorage extends JpaRepository<StorageData, UUID> {
}
