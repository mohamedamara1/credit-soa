package org.example.clientservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private boolean blacklisted;


}
