package school.hei.gestionVente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.gestionVente.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUsersByUsernameIs(String name);
  Optional<User> findByUsername(String name);
}
