package in.abhi.rail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.rail.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
