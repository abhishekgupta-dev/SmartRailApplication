package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.TrainSchedule;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Long>
{

}
