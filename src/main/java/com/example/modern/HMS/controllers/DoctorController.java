package com.example.modern.HMS.controllers;

import com.example.modern.HMS.dto.DoctorDto;
import com.example.modern.HMS.dto.Response;
import com.example.modern.HMS.entity.Doctor;
import com.example.modern.HMS.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    Response response=new Response();

    @PostMapping("/createDoctor")
    public ResponseEntity<Object> createDoctor(@RequestBody DoctorDto doctorDto){

        try{
            if(doctorDto.getName()==null||doctorDto.getSpeciality()==null||doctorDto.getContact_information()==null||doctorDto.getAvailability()==null||doctorDto.getDepartment()==null||doctorDto.getAssigned_patient()==null||doctorDto.getRemarks()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[DoctorName,Speciality,Contact information,Availability,Department,Assigned patient,Remark].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.message = "Doctor created  successfully.";
            response.data = doctorService.createDoctor(doctorDto);

        }
        catch (Exception ex){
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An unexpected error occurred creating Doctor.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable Integer id) {
        try {
            Optional<Doctor> doctor = doctorService.getDoctorById(id);
            if (doctor.isPresent()) {
                return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Record not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while fetching the doctor.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<Object> deleteDoctorById(@PathVariable Integer id,DoctorDto doctorDto) {
        try {
            Optional<Doctor> doctor = doctorService.getDoctorById(id);
            if (doctor.isPresent()) {
                doctorService.deleteDoctorById(id);
                response.status = Response.STATUS.Success.toString();
                response.message = "Doctor deleted successfully.";
                response.data=doctorService.createDoctor(doctorDto);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Record not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while deleting the doctor.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateDoctor/{id}") // Use path variable for user ID
    public ResponseEntity<Object> updateDoctor(
            @RequestBody DoctorDto doctorDto,
            @PathVariable Integer id // Inject user ID from the path
    ){
        try{
            response.message = "Doctor Updated  successfully.";
            response.data = doctorService.updateDoctor(doctorDto, id);

        }catch (Exception ex){
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while deleting the doctor.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
