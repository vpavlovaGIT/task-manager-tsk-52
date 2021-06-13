package ru.vpavlova.tm.api;

import org.jetbrains.annotations.NotNull;

public interface IPropertyService extends ISaltSetting {

    @NotNull
    String getJdbcUrl();

    @NotNull
    String getJdbcDriver();

    @NotNull
    String getJdbcUser();

    @NotNull
    String getJdbcPassword();

    @NotNull
    String getDialect();

    @NotNull
    String getHbm2ddlAuto();

    @NotNull
    String getShowSql();

}
