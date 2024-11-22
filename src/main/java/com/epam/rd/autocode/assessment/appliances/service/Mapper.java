package com.epam.rd.autocode.assessment.appliances.service;

import com.epam.rd.autocode.assessment.appliances.model.*;

public class Mapper {

    public static Manufacturer csvToManufacturer(String[] values) {
        if (values == null || values.length < 2) {
            return null;
        }

        long id = 0L;
        if (values[0] != null && !values[0].isEmpty()) {
                id = Long.parseLong(values[0]);
        }
        String name = values[1];
        return new Manufacturer(id, name);
    }


    public static String[] manufacturerToCsv(Manufacturer manufacturer) {
        return new String[] {
                manufacturer.getId() != 0 ? String.valueOf(manufacturer.getId()) : null,
                manufacturer.getName()
        };
    }

    public static Order csvToOrder(String[] values) {
        long id = values[0] != null && !values[0].isEmpty() ? Long.parseLong(values[0]) : 0;
        long clientId = values[1] != null && !values[1].isEmpty() ? Long.parseLong(values[1]) : 0;
        long employeeId = values[2] != null && !values[2].isEmpty() ? Long.parseLong(values[2]) : 0;
        return new Order(id, clientId, employeeId);
    }

    public static String[] orderToCsv(Order order) {
        return new String[] {
                order.getId() != 0 ? String.valueOf(order.getId()) : null,
                order.getClientId() != 0 ? String.valueOf(order.getClientId()) : null,
                order.getEmployeeId() != 0 ? String.valueOf(order.getEmployeeId()) : null,
        };
    }

    public static Client csvToClient(String[] values) {
        long id = values[0] != null && !values[0].isEmpty() ? Long.parseLong(values[0]) : 0;
        String name = values[1] != null ? values[1] : null;
        String email = values[2] != null ? values[2] : null;
        String password = values[3] != null ? values[3] : null;
        String card = values[4] != null ? values[4] : null;

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        Client client = new Client();
        client.setId(user.getId());
        client.setName(user.getName());
        client.setEmail(user.getEmail());
        client.setPassword(user.getPassword());
        client.setCard(card);

        return client;
    }

    public static String[] clientToCsv(Client client) {
        return new String[] {
                client.getId() != 0 ? String.valueOf(client.getId()) : null,
                client.getName(),
                client.getEmail(),
                client.getPassword(),
                client.getCard()
        };
    }

    public static Employee csvToEmployee(String[] values) {
        Employee employee = new Employee();
        long id = 0L;
        if (values[0] != null && !values[0].isEmpty()) {
                id = Long.parseLong(values[0]);
        }
        employee.setId(id);
        employee.setName(values[1]);
        employee.setEmail(values[2]);
        employee.setPassword(values[3]);
        employee.setDepartment(values[4]);
        return employee;
    }

    public static String[] employeeToCsv(Employee employee) {
        return new String[] {
                employee.getId() != 0 ? String.valueOf(employee.getId()) : null,
                employee.getName() != null ? employee.getName() : null,
                employee.getEmail() != null ? employee.getEmail() : null,
                employee.getPassword() != null ? employee.getPassword() : null,
                employee.getDepartment() != null ? employee.getDepartment() : null
        };
    }


    public static Appliance csvToAppliance(String[] values) {
        Appliance appliance = new Appliance();

        appliance.setId(values[0] != null && !values[0].isEmpty() ? Long.parseLong(values[0]) : 0);
        appliance.setName(values[1] != null ? values[1] : "null");
        appliance.setCategory(values[2] != null && !values[2].isEmpty() ? Category.valueOf(values[2]) : null);
        appliance.setModel(values[3] != null ? values[3] : "null");
        appliance.setManufacturerId(values[4] != null && !values[4].isEmpty() ? Long.parseLong(values[4]) : 0);
        appliance.setPowerType(values[5] != null && !values[5].isEmpty() ? PowerType.valueOf(values[5]) : null);
        appliance.setCharacteristic(values[6] != null ? values[6] : "null");
        appliance.setDescription(values[7] != null ? values[7] : "null");
        appliance.setPower(values[8] != null && !values[8].isEmpty() ? Integer.parseInt(values[8]) : 0);

        return appliance;
    }

    public static String[] applianceToCsv(Appliance appliance) {
        return new String[] {
                appliance.getId() != 0 ? String.valueOf(appliance.getId()) : null,
                appliance.getName() != null ? appliance.getName() : "",
                appliance.getCategory() != null ? appliance.getCategory().name() : "",
                appliance.getModel() != null ? appliance.getModel() : "",
                appliance.getManufacturerId() != 0 ? String.valueOf(appliance.getManufacturerId()) : null,
                appliance.getPowerType() != null ? appliance.getPowerType().name() : "",
                appliance.getCharacteristic() != null ? appliance.getCharacteristic() : "",
                appliance.getDescription() != null ? appliance.getDescription() : "",
                appliance.getPower() != 0 ? String.valueOf(appliance.getPower()) : null
        };
    }
}

