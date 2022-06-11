package savvycom.user.service;

import savvycom.user.domain.entity.User;
import savvycom.user.domain.model.UserModel;

import java.util.List;

public interface IUserService {
    void delete(User user);

    List<UserModel> findAll();

    UserModel findById(Integer id);

    UserModel findByUsername(String username);

    Boolean existsByUsername(String username);

    List<String> findUserRoles(String username);
}