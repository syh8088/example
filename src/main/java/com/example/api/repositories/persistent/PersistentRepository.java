package com.example.api.repositories.persistent;

import com.example.api.model.entities.member.PersistentLoginToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersistentRepository extends JpaRepository<PersistentLoginToken, Long> {

    PersistentLoginToken findBySeries(String series);

    List<PersistentLoginToken> findById(String id);
}
