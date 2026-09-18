package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.TrainRoute;

public interface TrainRouteRepository  extends JpaRepository<TrainRoute,Long>{

}
