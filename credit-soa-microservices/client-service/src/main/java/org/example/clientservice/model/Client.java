package org.example.clientservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = "cin"))
public class Client {

    @Id
    
    private String cin;
    private String name;
    private double salary;
    private String contractType;
    private String birthDate;
    // TO:DO: recheck the code if theres is an issue
    private boolean blacklisted = false;

    public Client() {

    }

    public Client(String cin, String name, double salary, String contractType, String birthDate, boolean blacklisted) {
        this.cin = cin;
        this.name = name;
        this.salary = salary;
        this.contractType = contractType;
        this.birthDate = birthDate;
        this.blacklisted = blacklisted;
    }

    public Client(String cin, String name, double salary, String contractType, String birthDate) {
        this.cin = cin;
        this.name = name;
        this.salary = salary;
        this.contractType = contractType;
        this.birthDate = birthDate;

    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }
}
