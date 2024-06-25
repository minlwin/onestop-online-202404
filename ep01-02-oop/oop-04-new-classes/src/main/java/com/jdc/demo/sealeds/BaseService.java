package com.jdc.demo.sealeds;

public sealed class BaseService 
	permits AppointmentService, DoctorService, PatientService{

}
