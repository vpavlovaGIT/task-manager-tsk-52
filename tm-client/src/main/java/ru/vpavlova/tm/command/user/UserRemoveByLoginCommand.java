package ru.vpavlova.tm.command.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.command.AbstractCommand;
import ru.vpavlova.tm.enumerated.Role;
import ru.vpavlova.tm.util.TerminalUtil;

public class UserRemoveByLoginCommand extends AbstractCommand {

    @Nullable
    @Override
    public String arg() {
        return null;
    }

    @NotNull
    @Override
    public String name() {
        return "user-remove-by-login";
    }

    @NotNull
    @Override
    public String description() {
        return "Remove by login user.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVE USER]");
        System.out.println("ENTER LOGIN:");
        final String login = TerminalUtil.nextLine();
        serviceLocator.getUserService().removeByLogin(login);
    }

    @NotNull
    @Override
    public Role[] roles() {
        return new Role[]{Role.ADMIN};
    }

}