package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.course.server.models.users.AppUser;

import java.util.Optional;

@Repository
public interface AppUserJpaSpringRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLogin(String login);
}
