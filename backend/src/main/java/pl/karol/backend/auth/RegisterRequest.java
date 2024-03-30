package pl.karol.backend.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 30, message = "Firstname must be between 2 and 30 characters long")
    private String firstname;
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 30, message = "Lastname must be between 2 and 30 characters long")
    private String lastname;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
}
