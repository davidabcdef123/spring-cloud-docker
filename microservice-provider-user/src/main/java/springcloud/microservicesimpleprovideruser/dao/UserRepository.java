package springcloud.microservicesimpleprovideruser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcloud.microservicesimpleprovideruser.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
