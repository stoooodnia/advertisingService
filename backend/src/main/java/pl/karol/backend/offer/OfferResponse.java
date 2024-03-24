package pl.karol.backend.offer;

import java.util.List;

public class OfferResponse {
    private List<Offer> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
}
