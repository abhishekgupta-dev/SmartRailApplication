package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.Station;

public interface StationRepository extends JpaRepository<Station,Long>{

}
