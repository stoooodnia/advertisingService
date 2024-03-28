package pl.karol.backend.offer;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.karol.backend.specialization.Specialization;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    @Size(min = 3, max = 30, message = "Firstname must be between 3 and 30 characters long")
    private String firstname;
    @NotBlank
    @Size(min = 3, max = 30, message = "Lastname must be between 3 and 30 characters long")
    private String lastname;
    @NotBlank
    @Size(min = 3, max = 50, message = "Content must be between 3 and 50 characters long")
    private String content;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
}
