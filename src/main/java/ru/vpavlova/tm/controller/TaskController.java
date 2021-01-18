package ru.vpavlova.tm.controller;

import ru.vpavlova.tm.api.controller.ITaskController;
import ru.vpavlova.tm.api.service.ITaskService;
import ru.vpavlova.tm.enumerated.Status;
import ru.vpavlova.tm.model.Project;
import ru.vpavlova.tm.model.Task;
import ru.vpavlova.tm.util.TerminalUtil;

import java.util.Arrays;
import java.util.List;

public class TaskController implements ITaskController {

    private final ITaskService taskService;

    public TaskController(final ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void showList() {
        System.out.println("[TASK LIST]");
        final List<Task> tasks = taskService.findAll();
        int index = 1;
        for (final Task task : tasks) {
            System.out.println(index + ". " + task);
            index++;
        }
        System.out.println("[OK]");
    }

    @Override
    public void create() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task task = taskService.add(name, description);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        System.out.println("[OK]");
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
        if (task == null) {
            System.out.println("[FAILED]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void showTaskByIndex() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.findOneByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void showTaskByName() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.findOneByName(name);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void removeTaskById() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.removeOneById(id);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void removeTaskByIndex() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.removeOneByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void removeTaskByName() {
        System.out.println("[SHOW TASK]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.removeOneByName(name);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        showTask(task);
        System.out.println("[OK]");
    }

    @Override
    public void updateTaskById() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.findOneById(id);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task taskUpdatedId = taskService.updateTaskById(id, name, description);
        if (taskUpdatedId == null) {
            System.out.println("[FAIL]");
            return;
        }
        System.out.println("[OK]");
    }

    @Override
    public void updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.findOneByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return;
        }
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        System.out.println("ENTER DESCRIPTION:");
        final String description = TerminalUtil.nextLine();
        final Task taskUpdatedIndex = taskService.updateTaskByIndex(index, name, description);
        if (taskUpdatedIndex == null) {
            System.out.println("[FAIL]");
            return;
        }
        System.out.println("[OK]");
    }

    @Override
    public void startProjectById() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.startProjectById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

    @Override
    public void startProjectByIndex() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.startProjectByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

    @Override
    public void startProjectByName() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.startProjectByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

    @Override
    public void finishProjectById() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER ID:");
        final String id = TerminalUtil.nextLine();
        final Task task = taskService.finishProjectById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

    @Override
    public void finishProjectByIndex() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER INDEX:");
        final Integer index = TerminalUtil.nextNumber() - 1;
        final Task task = taskService.finishProjectByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

    @Override
    public void finishProjectByName() {
        System.out.println("[SHOW PROJECT]");
        System.out.println("ENTER NAME:");
        final String name = TerminalUtil.nextLine();
        final Task task = taskService.finishProjectByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
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
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
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
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
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
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
    }

}
