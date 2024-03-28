package pl.karol.backend.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
    private List<SingleOfferDto> content;
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElements;
}
