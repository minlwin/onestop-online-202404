package com.jdc.demo.sealeds;

public sealed class DoctorService extends BaseService 
	permits ParttimeDoctorService, ParmenantDoctorService{

}
