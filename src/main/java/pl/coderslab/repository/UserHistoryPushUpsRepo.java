package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserHistoryPushUps;

import java.util.List;


public interface UserHistoryPushUpsRepo extends JpaRepository<UserHistoryPushUps, Long> {

    List<UserHistoryPushUps> findAllByUsers (User user);
}
