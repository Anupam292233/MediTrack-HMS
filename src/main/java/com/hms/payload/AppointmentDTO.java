package com.hms.payload;



import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private LocalDateTime appointmentDateTime;
    private String reasonForVisit;

    public LocalDateTime getAppointmentDate() {
        return null;
    }
}