package ru.vpavlova.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.enumerated.Status;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractBusinessEntityDTO extends AbstractEntityDTO {

    @Column
    @NotNull
    protected String userId;

    @Column
    @NotNull
    protected String name = "";

    @Column
    @NotNull
    protected String description = "";

    @NotNull
    @Enumerated(EnumType.STRING)
    protected Status status = Status.NOT_STARTED;

    @Column
    @Nullable
    protected Date dateStart;

    @Column
    @Nullable
    protected Date dateFinish;

    @Column
    @NotNull
    protected Date created = new Date();

    @NotNull
    public String toString() {
        return getId() + ": " + name + "; " + description + ";" + status;
    }

}
