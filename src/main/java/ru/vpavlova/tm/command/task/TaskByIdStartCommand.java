package ru.vpavlova.tm.command.task;

import ru.vpavlova.tm.command.AbstractTaskCommand;
import ru.vpavlova.tm.exception.entity.TaskNotFoundException;
import ru.vpavlova.tm.entity.Task;
import ru.vpavlova.tm.util.TerminalUtil;

import java.util.Optional;

public class TaskByIdStartCommand extends AbstractTaskCommand {

    @Override
    public String arg() {
        return null;
    }

    @Override
    public String name() {
        return "task-start-status-by-id";
    }

    @Override
    public String description() {
        return "Start task status by id.";
    }

    @Override
    public void execute() {
        System.out.println("[START PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final String userId = serviceLocator.getAuthService().getUserId();
        final Optional<Task> task = serviceLocator.getTaskService().startOneById(userId, id);
        if (!task.isPresent()) throw new TaskNotFoundException();
    }

}
