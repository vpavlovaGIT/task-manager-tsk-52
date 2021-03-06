package ru.vpavlova.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;
import ru.vpavlova.tm.listener.LoggerEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_session")
@EntityListeners(LoggerEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SessionGraph extends AbstractGraphEntity implements Cloneable {

    @Override
    public SessionGraph clone() {
        try {
            return (SessionGraph) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Column
    @Nullable
    private Long timestamp = System.currentTimeMillis();

    @Column
    @Nullable
    private String signature;

    @Nullable
    @ManyToOne
    @JsonIgnore
    private UserGraph user;

}
