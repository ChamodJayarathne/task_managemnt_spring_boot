
// package com.chamod.taskmanager.controller;

// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.*;
// import com.chamod.taskmanager.dto.request.RequestUserDto;
// import com.chamod.taskmanager.jwt.AuthenticationRequest;
// import com.chamod.taskmanager.service.UserService;
// import com.chamod.taskmanager.service.impl.UserDetailsServiceImpl;
// import com.chamod.taskmanager.util.JwtUtil;
// import com.chamod.taskmanager.util.StandardResponse;

// @RequiredArgsConstructor
// @RestController
// @RequestMapping("/api/v1/users")
// @CrossOrigin(origins = "http://localhost:3000")
// public class UserController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final AuthenticationManager authenticationManager;
//     private final UserDetailsServiceImpl userDetailsService;

//     @PostMapping("/register")
//     public ResponseEntity<StandardResponse> registerUser(@RequestBody RequestUserDto userDto) {
//         String name = userService.signup(userDto);
//         return new ResponseEntity<>(
//                 new StandardResponse(201, "User was saved!", name),
//                 HttpStatus.CREATED);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<StandardResponse> loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
//         try {
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                     authenticationRequest.getUsername(), authenticationRequest.getPassword()));

//             final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//             final String jwt = jwtUtil.generateToken(userDetails.getUsername());

//             return ResponseEntity.ok(new StandardResponse(HttpStatus.OK.value(), "Authentication successful", jwt));
//         } catch (BadCredentialsException e) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                     .body(new StandardResponse(HttpStatus.UNAUTHORIZED.value(),
//                             "Invalid username or password. Please try again", null));
//         } catch (AuthenticationException e) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                     .body(new StandardResponse(HttpStatus.UNAUTHORIZED.value(),
//                             "Authentication failed: " + e.getMessage(), null));
//         }
//     }

//     @ExceptionHandler(AuthenticationException.class)
//     public ResponseEntity<StandardResponse> handleAuthenticationException(AuthenticationException e) {
//         HttpStatus status = HttpStatus.UNAUTHORIZED;
//         return ResponseEntity.status(status)
//                 .body(new StandardResponse(status.value(), "Invalid username or password. Please try again", null));
//     }
// }

package com.chamod.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.chamod.taskmanager.dto.request.RequestUserDto;
import com.chamod.taskmanager.jwt.AuthenticationRequest;
import com.chamod.taskmanager.service.UserService;
import com.chamod.taskmanager.service.impl.UserDetailsServiceImpl;
import com.chamod.taskmanager.util.JwtUtil;
import com.chamod.taskmanager.util.StandardResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody RequestUserDto userDto) {
        String name = userService.signup(userDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "User was saved!", name),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<StandardResponse> loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new StandardResponse(HttpStatus.OK.value(), "Authentication successful", jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new StandardResponse(HttpStatus.UNAUTHORIZED.value(),
                            "Invalid username or password. Please try again", null));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new StandardResponse(HttpStatus.UNAUTHORIZED.value(),
                            "Authentication failed: " + e.getMessage(), null));
        }
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<StandardResponse> handleAuthenticationException(AuthenticationException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status)
                .body(new StandardResponse(status.value(), "Invalid username or password. Please try again", null));
    }
}
