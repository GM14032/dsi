package com.restaurante.dsi.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.*;
import jakarta.persistence.*;

@Entity @Setter @Getter @NoArgsConstructor
public class Roles {
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
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<Permissions> permissions = new HashSet<>();

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<Users> users;
    
    private static final long serialVersionUID = 1L;

}
