package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.Train;

public interface TrainRepository extends JpaRepository<Train,Long>{

}
