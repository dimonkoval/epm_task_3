package com.epam.rd.autocode.assessment.appliances.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private long id;
    private String name;
    private String email;
    private String password;

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', email='%s', password='%s'}",
                id, name, email, password);
    }
}
