package com.epam.rd.autocode.assessment.appliances.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Appliance {
    private long id;
    private String name;
    private Category category;
    private String model;
    private long manufacturerId;
    private PowerType powerType;
    private String characteristic;
    private String description;
    private int power;

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", name=" + name +
                ", model=" + model +
                ", manufacturerId=" + manufacturerId +
                ", powerType=" + powerType +
                ", characteristic=" + characteristic +
                ", description=" + description +
                ", power=" + power +
                (category != null ? ", category=" + category : "") +
                '}';
    }
}
