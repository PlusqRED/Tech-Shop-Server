package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.course.server.models.product.commons.Material;

@Repository
public interface MaterialJpaSpringRepository extends JpaRepository<Material, Integer> {
}
