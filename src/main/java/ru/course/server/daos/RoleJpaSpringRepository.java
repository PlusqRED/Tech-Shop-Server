package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.course.server.models.users.Role;

public interface RoleJpaSpringRepository extends JpaRepository<Role, Integer> {
}
