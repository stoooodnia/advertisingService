package pl.karol.backend.offer;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    public List<Offer> getPageOne() {
        Pageable paging = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        Page<Offer> pageResult = offerRepository.findAll(paging);
        return pageResult.getContent();
    }
}
