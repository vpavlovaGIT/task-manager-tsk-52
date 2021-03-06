package ru.vpavlova.tm.bootstrap;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.activemq.broker.BrokerService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.api.IPropertyService;
import ru.vpavlova.tm.api.endpoint.*;
import ru.vpavlova.tm.api.service.*;
import ru.vpavlova.tm.api.service.dto.*;
import ru.vpavlova.tm.api.service.model.*;
import ru.vpavlova.tm.dto.Session;
import ru.vpavlova.tm.endpoint.*;
import ru.vpavlova.tm.enumerated.Role;
import ru.vpavlova.tm.service.*;
import ru.vpavlova.tm.service.dto.*;
import ru.vpavlova.tm.service.model.*;
import ru.vpavlova.tm.util.SystemUtil;

import javax.xml.ws.Endpoint;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
public class Bootstrap implements ServiceLocator {

    @NotNull
    public final IPropertyService propertyService = new PropertyService();

    @NotNull
    public final IConnectionService connectionService = new ConnectionService(propertyService);

    @NotNull
    public final ISessionGraphService sessionService = new SessionGraphService(connectionService, this);

    @NotNull
    public final ISessionEndpoint sessionEndpoint = new SessionEndpoint(this);

    @NotNull
    public final ITaskEndpoint taskEndpoint = new TaskEndpoint(this);

    @NotNull
    public final IProjectEndpoint projectEndpoint = new ProjectEndpoint(this);

    @NotNull
    public final IUserEndpoint userEndpoint = new UserEndpoint(this);

    @NotNull
    public final IAdminUserEndpoint adminEndpoint = new AdminUserEndpoint(this);

    @NotNull
    private final ITaskGraphService taskService = new TaskGraphService(connectionService);

    @NotNull
    private final IProjectTaskGraphService projectTaskService = new ProjectTaskGraphService(connectionService);

    @NotNull
    private final IProjectGraphService projectService = new ProjectGraphService(connectionService);

    @NotNull
    private final ILoggerService loggerService = new LoggerService();

    @NotNull
    private final IUserGraphService userService = new UserGraphService(propertyService, connectionService);

    @NotNull
    public final IProjectService projectDTOService = new ProjectService(connectionService);

    @NotNull
    public final IProjectTaskService projectTaskDTOService = new ProjectTaskService(connectionService);

    @NotNull
    public final ISessionService sessionDTOService = new SessionService(connectionService, this);

    @NotNull
    public final ITaskService taskDTOService = new TaskService(connectionService);

    @NotNull
    public final IUserService userDTOService = new UserService(propertyService, connectionService);

    @NotNull
    private final BackupService backupService = new BackupService(userDTOService, taskDTOService, projectDTOService, sessionDTOService);

    @NotNull
    private final IAdminDataEndpoint adminDataEndpoint = new AdminDataEndpoint(this, backupService);

    @NotNull
    public IActiveMQConnectionService activeMQConnectionService;

    @Nullable
    private Session session = null;

    public Bootstrap() {
    }

    private void textWelcome() {
        loggerService.debug("TEST!!");
        loggerService.info("*** WELCOME TO TASK MANAGER ***");
    }

    private void initActiveMQConnectionService() {
        activeMQConnectionService = new ActiveMQConnectionService(this);
    }

    @SneakyThrows
    public void initJMSBroker() {
        @NotNull final BrokerService broker = new BrokerService();
        @NotNull final String bindAddress = "tcp://" + BrokerService.DEFAULT_BROKER_NAME + ":" + BrokerService.DEFAULT_PORT;
        broker.addConnector(bindAddress);
        broker.start();
    }

    private void initEndpoint() {
        registry(sessionEndpoint);
        registry(taskEndpoint);
        registry(projectEndpoint);
        registry(userEndpoint);
        registry(adminEndpoint);
        registry(adminDataEndpoint);
    }

    private void registry(@NotNull final Object endpoint) {
        @NotNull final String host = propertyService.getServerHost();
        @NotNull final String port = propertyService.getServerPort();
        @NotNull final String name = endpoint.getClass().getSimpleName();
        @NotNull final String wsdl = "http://" + host + ":" + port + "/" + name + "?wsdl";
        System.out.println(wsdl);
        Endpoint.publish(wsdl, endpoint);
    }

    @SneakyThrows
    private void initPID() {
        @NotNull final String fileName = "task-manager.pid";
        @NotNull final String pid = Long.toString(SystemUtil.getPID());
        Files.write(Paths.get(fileName), pid.getBytes());
        @NotNull final File file = new File(fileName);
        file.deleteOnExit();
    }

    public void initUser() {
        userService.create("test", "test");
        userService.create("admin", "admin", Role.ADMIN);
    }

    @SneakyThrows
    public void init(@Nullable final String... args) {
        textWelcome();
        initPID();
        initJMSBroker();
        initActiveMQConnectionService();
        initEndpoint();
        initUser();
    }

    @NotNull
    @Override
    public IBackupService getDataService() {
        return backupService;
    }

}
