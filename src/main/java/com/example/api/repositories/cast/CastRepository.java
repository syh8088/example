package com.example.api.repositories.cast;

import com.example.api.model.entities.cast.CastContents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<CastContents, Long> {


}
