package savvycom.user.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import savvycom.user.domain.dto.MessageDto;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Component
public class HttpServletResponseUtil {
    public void createFailureResponse(HttpServletRequest request, HttpServletResponse response, int statusCode, Exception e) throws IOException {
        MessageDto message = new MessageDto(
                statusCode + "",
                false,
                request.getServletPath(),
                e.getMessage()
        );
        sendFailureResponse(response, message);
    }

    public void sendFailureResponse(HttpServletResponse response, MessageDto message) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON);
        response.setStatus(Integer.valueOf(message.getCode()));
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), message);
    }
}
