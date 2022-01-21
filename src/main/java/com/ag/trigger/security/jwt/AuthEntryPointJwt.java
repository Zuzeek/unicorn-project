package com.ag.trigger.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private static final Logger LOG = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    /**
     * HttpServletResponse.SC_UNAUTHORIZED is the 401 Status code.
     * It indicates that the request requires HTTP authentication.
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        LOG.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }

}
/**
 * If want to customize the response data, just use an ObjectMapper like following code:
 *
 * @Override public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
 * throws IOException, ServletException {
 * logger.error("Unauthorized error: {}", authException.getMessage());
 * <p>
 * response.setContentType(MediaType.APPLICATION_JSON_VALUE);
 * response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
 * <p>
 * final Map<String, Object> body = new HashMap<>();
 * body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
 * body.put("error", "Unauthorized");
 * body.put("message", authException.getMessage());
 * body.put("path", request.getServletPath());
 * <p>
 * final ObjectMapper mapper = new ObjectMapper();
 * mapper.writeValue(response.getOutputStream(), body);
 * }
 */
