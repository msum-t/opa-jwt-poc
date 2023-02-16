package jwt.opa.poc.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DocumentRepository extends JpaRepository<Document, Long> {
}