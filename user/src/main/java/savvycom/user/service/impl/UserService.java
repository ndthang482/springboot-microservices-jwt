package savvycom.user.service.impl;

import savvycom.user.client.MajorClient;
import savvycom.user.domain.dto.ExtendedMessageDto;
import savvycom.user.domain.model.MajorModel;
import savvycom.user.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import savvycom.user.domain.entity.User;
import savvycom.user.repository.UserRepository;
import savvycom.user.service.IUserService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;

    private final MajorClient majorClient;

    private final ModelMapper modelMapper;

    @Override
    public void delete(User user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll().stream()
                .map(user -> mapUserModelFrom(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserModel findById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return mapUserModelFrom(user);
        }
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (Objects.nonNull(user)) {
            return mapUserModelFrom(user);
        }
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<String> findUserRoles(String username) {
        UserModel user = findByUsername(username);
        return user.getRoles().stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toList());
    }

    public UserModel mapUserModelFrom(User user) {
        UserModel userModel = modelMapper.map(user, UserModel.class);
        ExtendedMessageDto message = majorClient.findById(userModel.getMajor().getId());
        userModel.setMajor(modelMapper.map(message.getData(), MajorModel.class));
        return userModel;
    }
}
