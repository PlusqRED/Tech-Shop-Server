package ru.course.server.models.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

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
}
