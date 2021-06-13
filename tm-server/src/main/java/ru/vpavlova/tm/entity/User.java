package ru.vpavlova.tm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.enumerated.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_user")
public class User extends AbstractEntity {

    @Column
    @NotNull
    private String login;

    @Column
    @NotNull
    private String passwordHash;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String middleName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column
    private boolean locked = false;

    @Nullable
    @OneToMany(mappedBy = "user")
    private List<Project> projects = new ArrayList<>();

    @Nullable
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    @Nullable
    @OneToMany(mappedBy = "user")
    private List<Session> sessions = new ArrayList<>();

}
