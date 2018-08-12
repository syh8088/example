package com.example.api.repositories.appnotice;

import com.example.api.entities.appnotice.AppNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppNoticeRepository extends JpaRepository<AppNotice, Long> {

    AppNotice findById(long id);

}
