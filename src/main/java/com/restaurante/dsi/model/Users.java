package com.restaurante.dsi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @Setter @Getter @NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastname;
    private String email;
    private String phone;
    @JsonProperty("user_name")
    @Column(name = "user_name")
    private String username;
    private String password;
    private boolean enable;

    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;
    @JsonProperty("update_at")
    @Column(name = "update_at")
    private Date updateAt ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @PrePersist
    public void  prePersist() {
        createAt=new Date();
    }
}
