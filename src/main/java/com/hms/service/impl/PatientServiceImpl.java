package com.hms.service.impl;

import com.hms.entity.Appointment;
import com.hms.entity.Billing;
import com.hms.entity.MedicalHistory;
import com.hms.entity.Patient;
import com.hms.payload.PatientDTO;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.BillingRepository;
import com.hms.repository.MedicalHistoryRepository;
import com.hms.repository.PatientRepository;
import com.hms.service.PatientService;

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;
    private final AppointmentRepository appointmentRepository;
    private final BillingRepository billingRepository;

    public PatientServiceImpl(PatientRepository patientRepository, MedicalHistoryRepository medicalHistoryRepository, AppointmentRepository appointmentRepository, BillingRepository billingRepository) {
        this.patientRepository = patientRepository;
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.appointmentRepository = appointmentRepository;
        this.billingRepository = billingRepository;
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setGender(patientDTO.getGender());

        patient = patientRepository.save(patient);

            MedicalHistory medicalHistory = new MedicalHistory();
            medicalHistory.setPatient(patient);
            medicalHistory.setAllergies(patientDTO.getMedicalHistoryDTO().getAllergies());
            medicalHistory.setPreviousIllnesses(patientDTO.getMedicalHistoryDTO().getPreviousIllnesses());
            medicalHistory.setCurrentMedications(patientDTO.getMedicalHistoryDTO().getCurrentMedications());
            medicalHistoryRepository.save(medicalHistory);


        Patient finalPatient = patient;
        Patient finalPatient1 = patient;
        patientDTO.getAppointments().forEach(appointmentDTO -> {
                Appointment appointment = new Appointment();
                appointment.setPatient(finalPatient1);
                appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
                appointment.setReasonForVisit(appointmentDTO.getReasonForVisit());
                appointmentRepository.save(appointment);
            });



            Billing billing = new Billing();
            billing.setPatient(finalPatient);
            billing.setInsuranceProvider(patientDTO.getBillings().getInsuranceProvider());
            billing.setPolicyNumber(patientDTO.getBillings().getPolicyNumber());
            billing.setTotalAmount(patientDTO.getBillings().getTotalAmount());
            billingRepository.save(billing);


        return finalPatient;
    }
}
