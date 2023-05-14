package com.restaurante.dsi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "role" })
public class Permission {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    @Column(name = "table_name")
    private String table;
    @Column(columnDefinition = "boolean default true")
    private boolean enable;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = new Date();
    }

}
