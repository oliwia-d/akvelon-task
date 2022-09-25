package pl.akvelon.akvelontask.model.container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.akvelon.akvelontask.exception.ContainerEmptyException;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Container implements Removable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer currentVolume;

    @Column
    private Integer maxVolume;

    @Column
    @Enumerated(EnumType.STRING)
    private ContainerType type;

    @Override
    public void remove(int volumeToRemove) {
        if (!canRemove(volumeToRemove)) {
            throw new ContainerEmptyException(this, volumeToRemove);
        }
        this.currentVolume -= volumeToRemove;
    }

    @Override
    public boolean canRemove(int volumeToRemove) {
        return this.currentVolume >= volumeToRemove;
    }

}
