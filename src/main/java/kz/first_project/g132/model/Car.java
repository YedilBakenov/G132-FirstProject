package kz.first_project.g132.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Car {
    private int id;
    private String model;
    private double engine;
    private int cost;
    private String country;
    private Manufacturer manufacturer;
}
