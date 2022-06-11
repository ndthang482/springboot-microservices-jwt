package savvycom.authentication.service;

import savvycom.authentication.domain.entity.Role;

public interface IRoleService {
    Role findById(Integer id);
}
