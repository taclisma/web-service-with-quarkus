package edu.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserService {
    private static final String ISSUER = "https://localhost:8080";

    @POST
    @Path("/getJwt")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String generate(final String fullName, final String email) {
        return Jwt.issuer(ISSUER)
                .upn(email)
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, fullName)
                .sign();
    }
    
}
