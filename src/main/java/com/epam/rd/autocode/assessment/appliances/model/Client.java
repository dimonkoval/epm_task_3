package com.epam.rd.autocode.assessment.appliances.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Client extends User {
    private String card;

    public Client(long id, String name, String email, String password, String card) {
        super(id, name, email, password);
        this.card = card;
    }

    @Override
    public String toString() {
        return String.format(
                "Client{%s, card='%s'}",
                super.toString().substring(super.toString().indexOf("{") + 1, super.toString().length() - 1),
                card
        );
    }
}
