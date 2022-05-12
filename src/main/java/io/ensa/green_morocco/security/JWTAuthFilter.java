//package io.ensa.green_morocco.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthFilter(AuthenticationManager authenticationManager) {
//        super();
//        this.authenticationManager = authenticationManager;
//        // to change the url of our preference for the authentication end point.
////        setFilterProcessesUrl("/authenticate");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//////        return super.attemptAuthentication(request, response);
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
////        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
////        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        AppUser user = null;
//        try {
//            user = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("......ACCESS 1" + user.getPassword());
//        return authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//    }
//
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
////        super.successfulAuthentication(request, response, chain, authResult);
//        User user = (User) authResult.getPrincipal();
//        Algorithm algorithm = Algorithm.HMAC256(SecurityConstant.SECRET.getBytes(StandardCharsets.UTF_8));
//        String accessToken = JWT.create()
//                .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
//                .withIssuer(request.getRequestURL().toString())
//                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//                .sign(algorithm);
//
////        String refreshToken = JWT.create()
////                .withSubject(user.getUsername())
////                .withExpiresAt(new Date(System.currentTimeMillis() + 10*60*10000))
////                .withIssuer(request.getRequestURL().toString())
////                .sign(algorithm);
//
////        response.setHeader("access_token",accessToken);
////        response.setHeader("refresh_token",refreshToken);
//        Map<String,String> tokens = new HashMap<>();
//        tokens.put(SecurityConstant.HEADER_STRING,SecurityConstant.TOKEN_PREFIX + " " + accessToken);
////        tokens.put("refresh_token",refreshToken);
//
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        new ObjectMapper().writeValue(response.getOutputStream(),tokens);
//    }
//}
