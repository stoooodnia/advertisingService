package pl.karol.backend.offer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

    @Query("SELECT o FROM Offer o WHERE o.firstname LIKE %?1% OR o.lastname LIKE %?1% OR o.specialization.label LIKE %?1%")
    Page<Offer> findByFirstnameOrLastnameOrSpecializationContaining(String search, Pageable paging);
}
