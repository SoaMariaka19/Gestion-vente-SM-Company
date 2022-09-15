package school.hei.gestionVente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.gestionVente.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller , Long> {
}
