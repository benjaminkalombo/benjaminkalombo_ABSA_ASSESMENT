package co.za.absa.assesement.benjaminkalombo.repository;

import co.za.absa.assesement.benjaminkalombo.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
