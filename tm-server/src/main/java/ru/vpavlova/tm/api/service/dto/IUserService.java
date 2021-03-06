package ru.vpavlova.tm.api.service.dto;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.dto.User;
import ru.vpavlova.tm.enumerated.Role;

import java.util.Optional;

public interface IUserService extends IService<User> {

    void create(@Nullable String login, @Nullable String password);

    void create(
            @Nullable String login, @Nullable String password, @Nullable String email
    );

    void create(
            @Nullable String login, @Nullable String password, @Nullable Role role
    );

    @NotNull
    Optional<User> findByLogin(@Nullable String login);

    boolean isLoginExist(@Nullable String login);

    void lockUserByLogin(@Nullable String login);

    void removeByLogin(@Nullable String login);

    void setPassword(@Nullable String userId, @Nullable String password);

    void unlockUserByLogin(@Nullable String login);

    void updateUser(
            @Nullable String userId,
            @Nullable String firstName,
            @Nullable String lastName,
            @Nullable String middleName
    );

    @SneakyThrows
    void remove(@Nullable User entity);
}
