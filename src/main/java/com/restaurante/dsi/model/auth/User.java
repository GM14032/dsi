package com.restaurante.dsi.model.auth;

import com.fasterxml.jackson.annotation.*;
import com.restaurante.dsi.model.notifications.UserNotification;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Date;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "users")
@Entity @Setter @Getter @NoArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "last_name")
    @NotBlank(message = "El apellido es obligatorio")
    private String lastname;
    @NotBlank(message = "El email es obligatorio")
    private String email;
    @NotBlank(message = "El teléfono es obligatorio")
    private String phone;

    @Column(name = "username", unique = true)
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
    @Column(columnDefinition = "boolean default true")
    private Boolean enable=true;
    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;
    @JsonProperty("update_at")
    @Column(name = "update_at")
    private Date updateAt;

    @Column(columnDefinition = "boolean default false")
    private  Boolean hasToken=false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties({"users"})
    private Role role;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<UserNotification> userNotification;
    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = new Date();
    }
}
