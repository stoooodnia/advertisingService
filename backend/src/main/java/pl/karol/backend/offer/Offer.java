package pl.karol.backend.offer;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String firstname;
    private String lastname;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
}
