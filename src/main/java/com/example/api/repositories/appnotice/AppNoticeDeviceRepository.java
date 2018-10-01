package com.example.api.repositories.appnotice;

import com.example.api.model.entities.appnotice.AppNoticeDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppNoticeDeviceRepository extends JpaRepository<AppNoticeDevice, Long> {

    AppNoticeDevice findByNoticeIdAndType(Long id, AppNoticeDevice.Type type);

    AppNoticeDevice deleteAllByIdAndType(Long id, AppNoticeDevice.Type type);

}
