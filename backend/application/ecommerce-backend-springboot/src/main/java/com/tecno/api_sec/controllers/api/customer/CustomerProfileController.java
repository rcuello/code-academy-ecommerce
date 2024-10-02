package com.tecno.api_sec.controllers.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecno.api_sec.configuration.security.filters.AuditDetails;
import com.tecno.api_sec.controllers.api.dtos.UserProfileDTO;
import com.tecno.api_sec.persistence.entity.UserEntity;
import com.tecno.api_sec.services.audit.AuditExtractorService;
import com.tecno.api_sec.services.security.AuthenticationServiceImpl;

// Ver Perfil
// Actualizar Perfil
@RestController
@RequestMapping("/customer/profile")
public class CustomerProfileController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private AuditExtractorService auditExtractorService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/my-profile")
    public ResponseEntity<UserProfileDTO> findMyProfile() {

        // Obtener el usuario actualmente autenticado
        UserEntity user = authenticationService.findCurrentUser();

        // Mapear las propiedades del UserEntity al UserProfileDTO
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(user.getId());
        userProfileDTO.setUsername(user.getUsername());
        userProfileDTO.setFirstName(user.getFirstName());
        userProfileDTO.setLastName(user.getLastName());
        userProfileDTO.setEmail(user.getEmail());
        userProfileDTO.setRole(user.getRole());
        userProfileDTO.setAuthorities(user.getAuthorities());

        AuditDetails audit = auditExtractorService.extractClientAudit();
        System.out.println(audit.getRemoteAddress());
        System.out.println(audit.getUserAgent());

        return ResponseEntity.ok(userProfileDTO);
    }
}
