package com.restaurante.dsi.model.auth;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.util.*;
import jakarta.persistence.*;

@Entity @Setter @Getter @NoArgsConstructor
@JsonIgnoreProperties({ "users" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

    @Column(columnDefinition = "boolean default true")
    private Boolean enable = true;
    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;
    @JsonProperty("update_at")
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"users"})
    private List<User> users;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = new Date();
    }
}
