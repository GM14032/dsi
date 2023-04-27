package com.restaurante.dsi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
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
    @JsonProperty("username")
    @Column(name = "username", unique = true)
    private String username;
    private String password;
    private boolean enable;

    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;
    @JsonProperty("update_at")
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties({ "users" })
    private Roles roles;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    private static final long serialVersionUID = 1L;
}
