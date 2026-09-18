package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
