package com.lloyd.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String lastName;

    private String firstName;

    private String middleName;

    private String gender;

    private String birthdate;

    @ManyToOne
    @JoinColumn(name = "designationId" , referencedColumnName = "designationId")
    private Designation designation;


}
