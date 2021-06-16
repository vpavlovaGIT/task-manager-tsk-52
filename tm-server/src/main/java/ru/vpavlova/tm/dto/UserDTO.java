package ru.vpavlova.tm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.vpavlova.tm.enumerated.Role;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_user")
public class UserDTO extends AbstractEntityDTO {

    @Column
    @NotNull
    private String login;

    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    @Column
    @NotNull
    private String email;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column
    private boolean locked = false;

}
