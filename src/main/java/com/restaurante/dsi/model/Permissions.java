package com.restaurante.dsi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Entity  @Setter @Getter @NoArgsConstructor
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String name;
    private String description;
    private boolean enable;

    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;
    @JsonProperty("update_at")
    @Column(name = "update_at")
    private Date updateAt ;

    @PrePersist
    public void  prePersist() {
        createAt=new Date();
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    private static final long serialVersionUID = 1L;
}
