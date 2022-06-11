package savvycom.authentication.service.impl;

import savvycom.authentication.domain.entity.Role;
import savvycom.authentication.repository.RoleRepository;
import savvycom.authentication.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }
}
