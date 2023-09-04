package com.restaurante.dsi.model.notifications;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurante.dsi.model.notifications.UserNotification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
public class Notification {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @JsonProperty("create_at")
    @Column(name = "create_at")
    private Date createAt;

    @OneToMany(mappedBy = "notification")
    @JsonIgnore
    private Set<UserNotification> userNotifications;

    private List<String> roles;
    private String redirect;
    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

}
