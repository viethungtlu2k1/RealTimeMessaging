package com.RealTimeMessaging.services.Impl;

import com.RealTimeMessaging.auth.AuthenticationRequest;
import com.RealTimeMessaging.auth.AuthenticationResponse;
import com.RealTimeMessaging.entity.Role;
import com.RealTimeMessaging.entity.User;
import com.RealTimeMessaging.repositories.RoleCustomRepo;
import com.RealTimeMessaging.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepo roleCustomRepo;
    private final JWTService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        List<Role> roles= null;
        if (user != null){
            roles = roleCustomRepo.getRoles(user);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> setRole = new HashSet<>();
        roles.stream().forEach(r -> setRole.add(new Role(r.getName())));
        user.setRoles(setRole);
        setRole.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        var jwtToken = jwtService.generateToken(user, authorities);
        var jwtRefreshToken = jwtService.generateRefreshToken(user, authorities);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
