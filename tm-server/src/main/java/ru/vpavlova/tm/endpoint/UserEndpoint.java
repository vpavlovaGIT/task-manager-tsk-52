package ru.vpavlova.tm.endpoint;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.api.endpoint.IUserEndpoint;
import ru.vpavlova.tm.api.service.ServiceLocator;
import ru.vpavlova.tm.dto.SessionDTO;
import ru.vpavlova.tm.dto.UserDTO;
import ru.vpavlova.tm.enumerated.Role;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class UserEndpoint extends AbstractEndpoint implements IUserEndpoint {

    public UserEndpoint(@NotNull ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Nullable
    @Override
    @WebMethod
    @SneakyThrows
    public UserDTO findUserByLogin(
            @WebParam (name = "session", partName = "session") @NotNull SessionDTO session,
            @WebParam(name = "login", partName = "login") @NotNull final String login
    ) {
        serviceLocator.getSessionService().validateAdmin(session, Role.ADMIN);
        return serviceLocator.getUserService().findByLogin(login);
    }

    @Override
    @Nullable
    @WebMethod
    @SneakyThrows
    public UserDTO findUserOneBySession(
            @WebParam(name = "session", partName = "session") @Nullable final SessionDTO session
    ) {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getUserService().findById(session.getUserId()).orElse(null);
    }

    @Override
    @WebMethod
    @SneakyThrows
    public void setPassword(
            @WebParam(name = "session", partName = "session") @Nullable final SessionDTO session,
            @WebParam(name = "password", partName = "password") @Nullable final String password
    ) {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getUserService().setPassword(session.getUserId(), password);
    }

}
