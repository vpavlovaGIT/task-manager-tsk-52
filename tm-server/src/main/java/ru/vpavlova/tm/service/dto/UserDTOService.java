package ru.vpavlova.tm.service.dto;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.api.IPropertyService;
import ru.vpavlova.tm.api.repository.dto.IUserDTORepository;
import ru.vpavlova.tm.api.service.IConnectionService;
import ru.vpavlova.tm.api.service.dto.IUserDTOService;
import ru.vpavlova.tm.dto.UserDTO;
import ru.vpavlova.tm.enumerated.Role;
import ru.vpavlova.tm.exception.empty.*;
import ru.vpavlova.tm.exception.entity.ObjectNotFoundException;
import ru.vpavlova.tm.exception.entity.UserNotFoundException;
import ru.vpavlova.tm.exception.user.LoginExistsException;
import ru.vpavlova.tm.repository.dto.UserDTORepository;
import ru.vpavlova.tm.util.HashUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public final class UserDTOService extends AbstractDTOService<UserDTO> implements IUserDTOService {

    @NotNull
    private final IPropertyService propertyService;

    public UserDTOService(
            @NotNull IPropertyService propertyService,
            @NotNull IConnectionService connectionService) {
        super(connectionService);
        this.propertyService = propertyService;
    }

    @Override
    @SneakyThrows
    public void add(@Nullable final UserDTO user) {
        if (user == null) throw new ObjectNotFoundException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.add(user);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void create(
            @Nullable final String login, @Nullable final String password
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        if (isLoginExist(login)) throw new LoginExistsException();
        if (password.isEmpty()) throw new EmptyPasswordException();
        @NotNull final UserDTO user = new UserDTO();
        user.setRole(Role.USER);
        user.setLogin(login);
        user.setPasswordHash(HashUtil.salt(propertyService, password));
    }

    @Override
    @SneakyThrows
    public void create(
            @Nullable final String login,
            @Nullable final String password,
            @Nullable final String email
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        if (isLoginExist(login)) throw new LoginExistsException();
        if (password.isEmpty()) throw new EmptyPasswordException();
        if (email.isEmpty()) throw new EmptyEmailException();
        @NotNull final UserDTO user = new UserDTO();
        user.setRole(Role.USER);
        user.setLogin(login);
        user.setPasswordHash(HashUtil.salt(propertyService, password));
        user.setEmail(email);
        add(user);
    }

    @Override
    @SneakyThrows
    public void create(
            @Nullable final String login,
            @Nullable final String password,
            @Nullable final Role role
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        if (isLoginExist(login)) throw new LoginExistsException();
        if (password.isEmpty()) throw new EmptyPasswordException();
        if (role == null) throw new EmptyRoleException();
        @NotNull final UserDTO user = new UserDTO();
        user.setRole(Role.USER);
        user.setLogin(login);
        user.setPasswordHash(HashUtil.salt(propertyService, password));
        user.setRole(role);
        add(user);
    }

    @NotNull
    @Override
    @SneakyThrows
    public Optional<UserDTO> findByLogin(
            @Nullable final String login
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
        return userRepository.findByLogin(login);
    }

    @Override
    @SneakyThrows
    public boolean isLoginExist(
            @Nullable final String login
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
        return userRepository.findByLogin(login).isPresent();
    }

    @Override
    @SneakyThrows
    public void lockUserByLogin(@Nullable final String login) {
        if (login.isEmpty()) throw new EmptyLoginException();
        @NotNull final Optional<UserDTO> userOptional = findByLogin(login);
        if (!userOptional.isPresent()) throw new UserNotFoundException();
        @NotNull final UserDTO user = userOptional.get();
        user.setLocked(true);
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.update(user);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void removeByLogin(
            @Nullable final String login
    ) {
        if (login.isEmpty()) throw new EmptyLoginException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.removeByLogin(login);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void setPassword(
            @Nullable final String userId, @Nullable final String password
    ) {
        if (userId.isEmpty()) throw new EmptyUserIdException();
        if (password.isEmpty()) throw new EmptyPasswordException();
        @NotNull final Optional<UserDTO> user = findOneById(userId);
        if (!user.isPresent()) return;
        @Nullable final String hash = HashUtil.salt(propertyService, password);
        if (hash == null) return;
        user.get().setPasswordHash(hash);
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.update(user.get());
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void unlockUserByLogin(@Nullable final String login) {
        if (login.isEmpty()) throw new EmptyLoginException();
        @NotNull final Optional<UserDTO> userOptional = findByLogin(login);
        if (!userOptional.isPresent()) throw new UserNotFoundException();
        @NotNull final UserDTO user = userOptional.get();
        user.setLocked(false);
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.update(user);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void updateUser(
            @Nullable final String userId,
            @Nullable final String firstName,
            @Nullable final String lastName,
            @Nullable final String middleName
    ) {
        if (userId.isEmpty()) throw new EmptyUserIdException();
        @NotNull final Optional<UserDTO> user = findOneById(userId);
        if (!user.isPresent()) throw new ObjectNotFoundException();
        user.get().setFirstName(firstName);
        user.get().setLastName(lastName);
        user.get().setMiddleName(middleName);
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.update(user.get());
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void addAll(@Nullable List<UserDTO> entities) {
        if (entities == null) throw new ObjectNotFoundException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            entities.forEach(userRepository::add);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void clear() {
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.clear();
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @SneakyThrows
    public void remove(@Nullable final UserDTO entity) {
        if (entity == null) throw new ObjectNotFoundException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.removeOneById(entity.getId());
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @NotNull
    @Override
    @SneakyThrows
    public List<UserDTO> findAll() {
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
        return userRepository.findAll();
    }

    @NotNull
    @Override
    @SneakyThrows
    public Optional<UserDTO> findOneById(
            @Nullable final String id
    ) {
        if (id.isEmpty()) throw new EmptyIdException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
        return userRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public void removeOneById(
            @Nullable final String id
    ) {
        if (id.isEmpty()) throw new EmptyIdException();
        @NotNull final EntityManager entityManager = connectionService.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            @NotNull final IUserDTORepository userRepository = new UserDTORepository(entityManager);
            userRepository.removeOneById(id);
            entityManager.getTransaction().commit();
        } catch (@NotNull final Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
