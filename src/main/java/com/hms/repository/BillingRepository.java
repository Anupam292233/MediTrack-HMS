package com.hms.repository;

import com.hms.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing,Long> {
    Billing findByPatientId(Long patientId);

}
