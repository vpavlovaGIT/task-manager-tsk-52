package ru.vpavlova.tm.controller;

import ru.vpavlova.tm.api.controller.ITaskController;
import ru.vpavlova.tm.api.service.IProjectTaskService;
import ru.vpavlova.tm.api.service.ITaskService;
import ru.vpavlova.tm.enumerated.Sort;
import ru.vpavlova.tm.enumerated.Status;
import ru.vpavlova.tm.exception.entity.TaskNotFoundException;
import ru.vpavlova.tm.model.Task;
import ru.vpavlova.tm.util.TerminalUtil;

import java.util.Arrays;
import java.util.List;

public class TaskController implements ITaskController {

    private final ITaskService taskService;

    private final IProjectTaskService projectTaskService;

    public TaskController(final ITaskService taskService, IProjectTaskService projectTaskService) {
        this.taskService = taskService;
        this.projectTaskService = projectTaskService;
    }

    @Override
    public void showList() {
        System.out.println("[TASK LIST]");
        System.out.println("ENTER SORT:");
        System.out.println(Arrays.toString(Sort.values()));
        final String sort = TerminalUtil.nextLine();
        List<Task> tasks;
        if (sort == null || sort.isEmpty()) tasks = taskService.findAll();
        else {
            final Sort sortType = Sort.valueOf(sort);
            System.out.println(sortType.getDisplayName());
            tasks = taskService.findAll(sortType.getComparator());
        }
        int index = 1;
        for (final Task task : tasks) {
            System.out.println(index + ". " + task);
            index++;
        }
    }

    @Override
    public void create() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task task = taskService.add(name, description);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void clear() {
        System.out.println("[TASK CLEAR]");
        taskService.clear();
        System.out.println("[OK]");
    }

    private void showTask(final Task task) {
        if (task == null) return;
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("STATUS: " + task.getStatus().getDisplayName());
    }

    @Override
    public void showTaskById() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.findOneById(id);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void showTaskByIndex() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.findOneByIndex(index);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void showTaskByName() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.findOneByName(name);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void removeTaskById() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.removeOneById(id);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void removeTaskByIndex() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.removeOneByIndex(index);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void removeTaskByName() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.removeOneByName(name);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

    @Override
    public void updateTaskById() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.findOneById(id);
        if (task == null) throw new TaskNotFoundException();
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task taskUpdatedId = taskService.updateTaskById(id, name, description);
        if (taskUpdatedId == null) throw new TaskNotFoundException();
    }

    @Override
    public void updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.findOneByIndex(index);
        if (task == null) throw new TaskNotFoundException();
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task taskUpdatedIndex = taskService.updateTaskByIndex(index, name, description);
        if (taskUpdatedIndex == null) throw new TaskNotFoundException();
    }

    @Override
    public void startProjectById() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.startProjectById(id);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void startProjectByIndex() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.startProjectByIndex(index);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void startProjectByName() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.startProjectByName(name);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void finishProjectById() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.finishProjectById(id);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void finishProjectByIndex() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.finishProjectByIndex(index);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void finishProjectByName() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.finishProjectByName(name);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void changeProjectStatusById() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        System.out.println("ENTER STATUS:");
        System.out.println(Arrays.toString(Status.values()));
        final String statusId = TerminalUtil.nextLine();
        final Status status = Status.valueOf(statusId);
        final Task task = taskService.changeProjectStatusById(id, status);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void changeProjectStatusByIndex() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        System.out.println("ENTER STATUS:");
        System.out.println(Arrays.toString(Status.values()));
        final String statusId = TerminalUtil.nextLine();
        final Status status = Status.valueOf(statusId);
        final Task task = taskService.changeProjectStatusByIndex(index, status);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void changeProjectStatusByName() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER STATUS:");
        System.out.println(Arrays.toString(Status.values()));
        final String statusId = TerminalUtil.nextLine();
        final Status status = Status.valueOf(statusId);
        final Task task = taskService.changeProjectStatusByName(name, status);
        if (task == null) throw new TaskNotFoundException();
    }

    @Override
    public void findAllTaskByProjectId() {
        System.out.println("[TASKS BY PROJECT]");
        System.out.println("[ENTER ID:]");
        final String projectId = TerminalUtil.nextLine();
        final List<Task> tasks = projectTaskService.findAllTaskByProjectId(projectId);
        int index = 1;
        for (Task task : tasks) {
            System.out.println(index + ". " + task);
            index++;
        }
    }

    @Override
    public void bindTaskByProject() {
        System.out.println("[BIND TASK WITH PROJECT]");
        System.out.println("[ENTER PROJECT ID:]");
        final String projectId = TerminalUtil.nextLine();
        System.out.println("[ENTER TASK ID:]");
        final String taskId = TerminalUtil.nextLine();
        final Task task = projectTaskService.bindTaskByProject(projectId, taskId);
        if (task == null) throw new TaskNotFoundException();
        System.out.println("TASK ADD TO PROJECT");
    }

    @Override
    public void unbindTaskFromProject() {
        System.out.println("[UNBIND TASK WITH PROJECT]");
        System.out.println("[ENTER PROJECT ID:]");
        final String taskId = TerminalUtil.nextLine();
        final Task task = projectTaskService.unbindTaskFromProject(taskId);
        if (task == null) throw new TaskNotFoundException();
        System.out.println("TASK REMOVE FROM PROJECT");
    }

}