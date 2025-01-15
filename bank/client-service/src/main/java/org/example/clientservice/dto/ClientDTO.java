package org.example.clientservice.dto;

import lombok.Builder;
import lombok.Data;
@Builder
public class ClientDTO {

    private String cin;
    private String name;
    private double salary;
    private String contractType;
    private String birthDate;
    private boolean blacklisted;

    public ClientDTO() {

    }

    public ClientDTO(String cin, String name, double salary, String contractType, String birthDate, boolean blacklisted) {
        this.cin = cin;
        this.name = name;
        this.salary = salary;
        this.contractType = contractType;
        this.birthDate = birthDate;
        this.blacklisted = blacklisted;
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
