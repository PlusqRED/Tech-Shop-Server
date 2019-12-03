package ru.course.server.models.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

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
}
