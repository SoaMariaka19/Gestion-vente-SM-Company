package school.hei.gestionVente.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.hei.gestionVente.model.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client , Long> {
  @Query(value=
                  "SELECT * FROM client " +
                          "LEFT JOIN to_buy" +
                          "ON to_buy.client_id = client.id " +
                          "LEFT JOIN supply" +
                          "ON supply.id_client = to_buy.client_id " +
                          "WHERE supply.id = :id "
                  ,nativeQuery = true
  )
  List<Client> findClient(
          @Param("id")Long id,
          Pageable pageable
  );
}
