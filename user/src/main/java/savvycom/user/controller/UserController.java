package savvycom.user.controller;

import savvycom.user.domain.dto.MessageDto;
import savvycom.user.domain.entity.User;
import savvycom.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController extends BaseController {
    private final IUserService userService;

    @GetMapping ()
    public MessageDto findAllUsers() {
        return createSuccessResponse(userService.findAll());
    }

    @GetMapping("/{id}")
    public MessageDto findById(@PathVariable Integer id) {
        return createSuccessResponse(userService.findById(id));
    }

    @GetMapping("/q")
    public MessageDto findByUsername(@RequestParam String username) {
        return createSuccessResponse(userService.findByUsername(username));
    }

    @DeleteMapping("/{id}")
    public MessageDto deleteUser(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return createSuccessResponse();
    }
}
