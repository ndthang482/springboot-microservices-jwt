package savvycom.user.client;

import savvycom.user.domain.dto.ExtendedMessageDto;
import savvycom.user.domain.dto.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth", configuration = FeignClientConfig.class)
public interface AuthClient {
    @PostMapping("/api/auth/user")
    ExtendedMessageDto validateToken();
}