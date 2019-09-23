package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {


    User findBySurname(String surname);
    User findByLogin (String login);
    User findById (Long id);





}
