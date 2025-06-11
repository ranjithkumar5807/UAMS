package auth.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.dto.AuthRequest;
import auth.entity.UserInfo;
import auth.repository.UserInfoRepository;
import auth.service.JwtService;
import auth.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserInfoRepository repo;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @GetMapping("/welcome")		//http://localhost:9090/auth/welcome
//    public String welcome() {
//        return "Welcome this endpoint is not secure";
//    }

    @PostMapping("/new")	//http://localhost:9090/auth/new
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }



    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            UserInfo obj = repo.findByEmail(authRequest.getUsername()).orElse(null);
            List<String> roles = Arrays.asList(obj.getRoles().split(","));  // e.g., "ROLE_USER,ROLE_ADMIN"
            System.out.println(roles);
            String token = jwtService.generateToken(authRequest.getUsername(), roles);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @GetMapping("/getroles/{username}")		//http://localhost:9090/auth/getroles/{username}
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getRoles(@PathVariable String username)
    {
    	return service.getRoles(username);
    }
}
