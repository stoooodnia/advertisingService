package pl.karol.backend.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/")
    public ResponseEntity<OfferResponse> getOffers (
            @RequestParam(value="page", defaultValue="0", required=false) int page,
            @RequestParam(value="size", defaultValue="9", required = false) int size) {
        return ResponseEntity.ok(offerService.getOffers(page, size));
    }
}
