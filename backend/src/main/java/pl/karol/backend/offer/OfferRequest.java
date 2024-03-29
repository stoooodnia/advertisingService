package pl.karol.backend.offer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 30, message = "Firstname must be between 3 and 30 characters long")
    private String firstname;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 30, message = "Lastname must be between 3 and 30 characters long")
    private String lastname;

    @NotBlank(message = "Content is mandatory")
    @Size(min = 3, max = 100, message = "Content must be between 3 and 100 characters long")
    private String content;

    @NotNull(message = "Created at is mandatory")
    private LocalDateTime createdAt;

    @NotNull(message = "Specialization id is mandatory")
    private Integer specializationId;
}
