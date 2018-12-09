package united.nearByShop.service.Rest.user;

import static united.nearByShop.service.Rest.user.SecurityConstants.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import united.nearByShop.bo.Administrateur;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	  private AuthenticationManager authenticationManager;

	    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	        setFilterProcessesUrl("/api/login");
	    }
	 // attemptAuthentication where we parse the user's credentials
	    // and issue them to the AuthenticationManager
	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest req,
	                                                HttpServletResponse res) throws AuthenticationException {
	        try {
	            Administrateur creds = new ObjectMapper()
	                    .readValue(req.getInputStream(), Administrateur.class);

	            return authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            creds.getEmail(),
	                            creds.getMotDePasse(),
	                            new ArrayList<>())
	            );
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    //successfulAuthentication which is the method called when a user successfully logs in.
	    // We use this method to generate a JWT for this user
	    @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {

	        String token = Jwts.builder()
	                .setSubject(((User) auth.getPrincipal()).getUsername())
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
	                .compact();
	        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	        res.addHeader("expiresAt", String.valueOf(System.currentTimeMillis() + EXPIRATION_TIME));
	        res.addHeader("Access-Control-Expose-Headers", "Authorization");
	        res.addHeader("Access-Control-Expose-Headers", "expiresAt");
	     
	    }

}
