package savvycom.major.client;

import savvycom.major.domain.dto.ExtendedMessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth", configuration = FeignClientConfig.class)
public interface AuthClient {
    @PostMapping("/api/auth/user")
    ExtendedMessageDto validateToken();
}
