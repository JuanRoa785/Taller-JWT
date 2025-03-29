package com.entornos.uis.tallerJWT.config;

import com.entornos.uis.tallerJWT.servicio.JWTService;
import com.entornos.uis.tallerJWT.servicio.UsuarioDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Juan Diego Roa
 */
@Component
public class JwtFilter extends  OncePerRequestFilter{

    @Autowired
    private JWTService jwtService; 
    
    @Autowired
    ApplicationContext  context;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        
        if (authHeader !=null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); //Ignoramos el "Bearer "
            username = jwtService.extractUserName(token);
        } 
        
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = context.getBean(UsuarioDetailsService.class).loadUserByUsername(username);
            
            if (jwtService.validateToken(token, userDetails) ) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
