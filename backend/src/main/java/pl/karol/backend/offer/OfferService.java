package pl.karol.backend.offer;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferResponse getOffers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Offer> pageResult = offerRepository.findAll(paging);
        List<Offer> listOfOffers =  pageResult.getContent();
        List<OfferDto> content = listOfOffers.stream().map(this::mapToDto).toList();
        return OfferResponse.builder()
                .content(content)
                .pageNo(page)
                .pageSize(size)
                .totalPages(pageResult.getTotalPages())
                .totalElements(pageResult.getTotalElements())
                .build();
    }

    private OfferDto mapToDto(Offer offer) {
        return OfferDto.builder()
                .id(offer.getId())
                .firstname(offer.getFirstname())
                .lastname(offer.getLastname())
                .specialization(offer.getSpecialization())
                .content(offer.getContent())
                .createdAt(offer.getCreatedAt())
                .build();
    }


}
