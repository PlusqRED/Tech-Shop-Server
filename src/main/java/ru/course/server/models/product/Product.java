package ru.course.server.models.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.course.server.models.product.commons.Color;
import ru.course.server.models.product.commons.Material;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private String description;
    private BigDecimal price;
    private String manufacturer;
    private LocalDate releaseDate;
    private Float weight;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material material;
}
