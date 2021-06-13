package ru.vpavlova.tm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.api.entity.IWBS;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_task")
public class Task extends AbstractBusinessEntity implements IWBS {

    @Nullable
    @ManyToOne
    private Project project;

}
