package school.hei.gestionVente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.hei.gestionVente.model.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply , Long> {
}
