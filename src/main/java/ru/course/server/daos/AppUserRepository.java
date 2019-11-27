package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.course.server.models.users.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
