package com.example.Blogging.platform.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer userId;
@NotNull(message = "username can not be null")
    @Column(name="user_Name")
    private String userName;
@NotNull(message = "password must be entered")
    @Column(name="user_password")
    private String password;
@NotNull(message="please enter valid email")
    @Column(name="user_email")
    private String email;
@NotNull(message="please enter phone number")
@Length(min=10,max=12,message="number should be in [10,12] only")
    @Column(name="user_phoneNumber")
    private String phoneNumber;
@NotNull(message="first name can can be empty")
    @Column(name="user_firstName")
    private String firstName;
@NotNull(message="last name can not be empty")
    @Column(name="user_lastName")
    private String lastName;
@NotNull(message="please enter age")
    @Column(name="user_age")
    private Integer age;

}
