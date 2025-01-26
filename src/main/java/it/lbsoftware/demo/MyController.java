package it.lbsoftware.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping("/roles")
    public Map<String, String> getRoles(@AuthenticationPrincipal Jwt jwt) {
        return Map.of("roles", getRolesFromJwt(jwt));
    }

    private String getRolesFromJwt(Jwt jwt) {
        var noRolesFoundMessage = "no roles found";
        var realmAccess = (Map<String, List<String>>) jwt.getClaim("realm_access");
        if (realmAccess == null || realmAccess.isEmpty()) {
            return noRolesFoundMessage;
        }
        var roles = realmAccess.get("roles");
        return (roles == null || roles.isEmpty()) ? noRolesFoundMessage : String.join(", ", roles);
    }

}
