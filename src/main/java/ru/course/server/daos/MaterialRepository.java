package ru.course.server.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.course.server.models.product.commons.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
