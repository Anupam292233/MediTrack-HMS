package com.hms.repository;

import com.hms.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long> {
    MedicalHistory findByPatientId(Long patientId);
}
