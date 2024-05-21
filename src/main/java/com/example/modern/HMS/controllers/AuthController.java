package com.example.modern.HMS.controllers;


import com.example.modern.HMS.entity.User;
import com.example.modern.HMS.dto.AuthenticationDto;
import com.example.modern.HMS.dto.RegistrationDto;
import com.example.modern.HMS.dto.Response;
import com.example.modern.HMS.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    Response response=new Response();

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegistrationDto request){

        try{
            if(request.getEmail()==null||request.getUsername()==null||request.getPassword()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[email,username,password].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else if (authenticationService.isEmailExist(request.getEmail())) {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Email already exists.";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.message = "User registered successfully.";
            response.data = authenticationService.register(request);
        }catch (Exception ex){
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationDto request){
        try{
            if(request.getUsername()==null||request.getPassword()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[username,password].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.status = Response.STATUS.Success.toString();
            response.message = "Login success.";
            response.data = authenticationService.authenticate(request);

        }catch (AuthenticationException ex) {
            response.status = Response.STATUS.Failed.toString();
            response.message = "Login failed. Invalid credentials.";
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        catch (Exception ex){
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        try {
            Optional<User> user = authenticationService.getUserById(id);
            if (user.isPresent()) {
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "User not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while fetching the user.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Integer id) {
        try {
            Optional<User> user = authenticationService.getUserById(id);
            if (user.isPresent()) {
                authenticationService.deleteUserById(id);
                response.status = Response.STATUS.Success.toString();
                response.message = "User deleted successfully.";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "User not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while deleting the user.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/update/{id}") // Use path variable for user ID
    public ResponseEntity<String> updateUser(
            @RequestBody RegistrationDto request,
            @PathVariable Integer id // Inject user ID from the path
    ){
        authenticationService.updateUser(request, id);
        return ResponseEntity.ok("User data updated successfully.");
    }

}
