package com.example.modern.HMS.controllers;

import com.example.modern.HMS.dto.DoctorDto;
import com.example.modern.HMS.dto.PatientDto;
import com.example.modern.HMS.dto.Response;
import com.example.modern.HMS.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    Response response=new Response();
    @PostMapping("/createPatient")
    public ResponseEntity<Object> createPatient(@RequestBody PatientDto patientDto){

        try{
            if(patientDto.getPatient_name()==null||patientDto.getDob()==null||patientDto.getGender()==null||patientDto.getAddress()==null||patientDto.getContact_information()==null||patientDto.getEmergency_contact()==null||patientDto.getInsurance_information()==null){
                response.status= Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[PatientName,DOB,gender,address,Contact information,Emergency contact,Insurance information].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.message = "Patient created  successfully.";
            response.data = patientService.createPatient(patientDto);

        }
        catch (Exception ex){
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An unexpected error occurred creating Patient.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
