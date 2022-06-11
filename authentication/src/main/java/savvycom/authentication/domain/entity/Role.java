package savvycom.authentication.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.authentication.domain.model.ERole;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private ERole name;
}
