package jwt.opa.poc.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyRepo extends JpaRepository<Policy,Long> {

    Optional<Policy> findByUsername(String username);






}
