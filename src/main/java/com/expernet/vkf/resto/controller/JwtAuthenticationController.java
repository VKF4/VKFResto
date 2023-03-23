package com.expernet.vkf.resto.controller;

import java.util.Base64;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.expernet.vkf.resto.model.Utilisateur;
import com.expernet.vkf.resto.repository.UtilisateurRepository;
import com.expernet.vkf.resto.utils.JwtTokenUtil;

@RestController
public class JwtAuthenticationController {
	
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public JwtAuthenticationController() {
    }

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> registerUser(@RequestBody Utilisateur utilisateur) throws Exception{
        boolean utilisateurExisteDeja = utilisateurRepository.findById(utilisateur.getUsername()).orElse(null) != null;
        if (utilisateurExisteDeja)
            throw new Exception("L'utilisateur existe déjà !");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        utilisateur.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode(utilisateur.getPassword()));
        utilisateurRepository.save(utilisateur);
        return ResponseEntity.ok(utilisateur);
    }

	@GetMapping("/login")
    public ResponseEntity<String> createAuthenticationToken(@RequestHeader Map<String, String> header, 
        @Value("${jwt.secret}") String secret) throws Exception{
        String username = getUsernameInRequestHeader(header);
        String password = getPasswordInRequestHeader(header);
        authenticate(username, password);
        Utilisateur utilisateur = utilisateurRepository.findById(username).orElse(null);
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        final String token = jwtTokenUtil.generateToken(utilisateur, secret);
        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findById(username).orElse(null);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (utilisateur != null && bCryptPasswordEncoder.matches(password, utilisateur.getPassword())){
            throw new Exception("INVALID_CREDENTIALS");
        }
    }


    private String getUsernameInRequestHeader(Map<String, String> header){
        String encodedUsernamePassword = header.get("authorization").split(" ")[1];
        String decodedUsernamePassword = new String(Base64.getDecoder().decode(encodedUsernamePassword));
        String username = decodedUsernamePassword.split(":")[0];
        return username;
    }

    private String getPasswordInRequestHeader(Map<String, String> header){
        String encodedUsernamePassword = header.get("authorization").split(" ")[1];
        String decodedUsernamePassword = new String(Base64.getDecoder().decode(encodedUsernamePassword));
        String password = decodedUsernamePassword.split(":")[1];
        return password;
    }
}
