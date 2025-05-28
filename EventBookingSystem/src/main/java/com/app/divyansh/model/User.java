package com.app.divyansh.model;

import com.app.divyansh.utility.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access=Access.READ_ONLY)
    @Column(name="uid")
    private Long idPk;
    @Column(name="uname")
    private String userName_Client;
    @Column(name="umail")
    private String userEmail;
    @Column(name="upassword")
    private String userPassword;
    @Enumerated(EnumType.STRING)
    private Role roleOfTheUser; 
}