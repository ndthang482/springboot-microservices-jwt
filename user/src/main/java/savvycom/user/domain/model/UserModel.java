package savvycom.user.domain.model;

import savvycom.user.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Integer id;

    private String name;

    private Set<Role> roles;

    private MajorModel major;
}