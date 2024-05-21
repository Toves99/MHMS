package com.example.modern.HMS.service;

import com.example.modern.HMS.config.JwtService;
import com.example.modern.HMS.enums.Role;
import com.example.modern.HMS.entity.User;
import com.example.modern.HMS.repository.TokenRepository;
import com.example.modern.HMS.repository.UserRepository;
import com.example.modern.HMS.dto.AuthenticationDto;
import com.example.modern.HMS.dto.AuthenticationResponse;
import com.example.modern.HMS.dto.RegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegistrationDto request){
        var user= User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .created_at(ZonedDateTime.now())
//                .updated_at(ZonedDateTime.now())
//                .deleted_at(ZonedDateTime.now())
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .id(user.getId())
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationDto request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user=userRepository.findByEmail(request.getUsername())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .id(user.getId())
                .token(jwtToken)
                .build();
    }

    public boolean isEmailExist(String email) {
        if(email==null)
            return false;
        Optional<User> m = userRepository.findByEmail(email);
        return m.isPresent();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
    public void updateUser(RegistrationDto request, Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(request.getEmail()!=null){
            user.setEmail(request.getEmail());
        }
        if(request.getUsername()!=null){
            user.setUsername(request.getUsername());
        }
        if(request.getPassword()!=null){
            user.setPassword(request.getPassword());
        }
        if(request.getUpdated_at()!=null){
            user.setUpdated_at(ZonedDateTime.now());
        }
        userRepository.save(user);
    }
}
