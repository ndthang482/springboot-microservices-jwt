package savvycom.user.client;

import savvycom.user.domain.dto.ExtendedMessageDto;
import savvycom.user.domain.model.MajorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "major", configuration = FeignClientConfig.class)
public interface MajorClient {
    @GetMapping("/api/majors/{id}")
    ExtendedMessageDto findById(@PathVariable Integer id);
}
