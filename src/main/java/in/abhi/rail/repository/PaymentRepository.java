package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

	
	
}
