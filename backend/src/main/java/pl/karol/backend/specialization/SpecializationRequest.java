package pl.karol.backend.specialization;


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
public class SpecializationRequest {
    @NotBlank(message = "Label is mandatory")
    @Size(min = 3,max = 20, message = "Label must be between 3 and 20 characters long")
    private String label;
}
