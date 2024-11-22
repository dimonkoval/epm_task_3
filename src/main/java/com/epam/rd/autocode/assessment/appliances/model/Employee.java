package com.epam.rd.autocode.assessment.appliances.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Employee extends User {
    private String department;

    public Employee(long id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee{%s, department='%s'}",
                super.toString().substring(super.toString().indexOf("{") + 1, super.toString().length() - 1),
                department
        );
    }
}
