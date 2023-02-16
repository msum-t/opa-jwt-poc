package jwt.opa.poc.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SalaryRepository extends JpaRepository<Salary, Long> {
    Optional<Salary> findByUsername(String username);
}