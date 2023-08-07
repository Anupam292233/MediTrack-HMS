package com.hms.payload;


import lombok.Data;

import java.util.List;
@Data
public class PatientDTO {

    private Long Id;
    private String name;
    private String dateOfBirth;
    private MedicalHistoryDTO medicalHistoryDTO;
    private List<AppointmentDTO> appointments;
    private BillingDTO billings;

    public String getGender() {
        return null;
    }

    public Object getMedicalHistory() {
        return null;
    }
}
