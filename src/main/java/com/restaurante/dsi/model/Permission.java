package com.restaurante.dsi.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    private boolean enable;


    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permission_role", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();

    private static final long serialVersionUID = 1L;
}
