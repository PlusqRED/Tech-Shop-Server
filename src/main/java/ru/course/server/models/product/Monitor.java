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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Monitor extends Product {
    private Float diagonal;
    private String aspectRatio;
    private String resolution;
    private String matrixType;
    private String matrixFrequency;
    private boolean builtInSpeakers;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}
