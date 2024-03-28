package pl.karol.backend.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.karol.backend.specialization.Specialization;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleOfferDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private Specialization specialization;
    private String content;
    private LocalDateTime createdAt;
}
