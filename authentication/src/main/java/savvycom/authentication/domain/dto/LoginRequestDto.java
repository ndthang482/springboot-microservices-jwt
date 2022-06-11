package savvycom.authentication.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 5, max = 25)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 25)
    private String password;
}
