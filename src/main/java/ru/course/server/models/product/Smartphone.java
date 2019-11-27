package ru.course.server.models.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.course.server.models.product.commons.Color;
import ru.course.server.models.product.commons.Material;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Smartphone extends Product {
    private String os;
    private Float displaySize;
    private String displayResolution;
    private String ram;
    private Short numberOfBackCameras;
    private Short numberOfFrontCameras;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}
