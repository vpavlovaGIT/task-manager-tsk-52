package ru.vpavlova.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.command.AbstractTaskCommand;
import ru.vpavlova.tm.endpoint.Session;
import ru.vpavlova.tm.endpoint.Status;
import ru.vpavlova.tm.endpoint.TaskEndpoint;
import ru.vpavlova.tm.exception.entity.ObjectNotFoundException;
import ru.vpavlova.tm.util.TerminalUtil;

import java.util.Arrays;

public class TaskByIndexChangeCommand extends AbstractTaskCommand {

    @Nullable
    @Override
    public String arg() {
        return null;
    }

    @NotNull
    @Override
    public String name() {
        return "change-task-status-by-index";
    }

    @NotNull
    @Override
    public String description() {
        return "Change task status by index.";
    }

    @Override
    public void execute() {
        System.out.println("[CHANGE PROJECT]");
        System.out.println("ENTER INDEX:");
        if (bootstrap == null) throw new ObjectNotFoundException();
        @Nullable final Session session = bootstrap.getSession();
        if (endpointLocator == null) throw new ObjectNotFoundException();
        @NotNull final Integer index = TerminalUtil.nextNumber() - 1;
        @NotNull final TaskEndpoint taskEndpoint = endpointLocator.getTaskEndpoint();
        System.out.println("ENTER STATUS:");
        System.out.println(Arrays.toString(Status.values()));
        @NotNull final String statusId = TerminalUtil.nextLine();
        @NotNull final Status status = Status.valueOf(statusId);
        taskEndpoint.changeTaskStatusByIndex(session, index, status);
    }

}
