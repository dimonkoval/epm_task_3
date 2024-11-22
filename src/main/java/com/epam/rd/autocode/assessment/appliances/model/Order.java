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
public class Order {
    private long id;
    private long clientId;
    private long employeeId;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

}
