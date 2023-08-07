package com.hms.payload;

import lombok.Data;

@Data
public class MedicalHistoryDTO {

    private String allergies;
    private String previousIllnesses;
    private String currentMedications;

}