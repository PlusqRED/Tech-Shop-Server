package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.course.server.models.product.Monitor;

@Repository
public interface MonitorJpaSpringRepository extends JpaRepository<Monitor, Long> {
}
