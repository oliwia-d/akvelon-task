package pl.akvelon.akvelontask.model.creature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Creature implements Drinkable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer currentVolume;

    @Column
    private Integer maxVolume;

    @Column
    @Enumerated(EnumType.STRING)
    private CreatureType type;

    @Override
    public void drink(int volumeToDrink) {
        this.currentVolume += volumeToDrink;
    }

    @Override
    public boolean canDrink(int volumeToDrink) {
        return this.maxVolume - this.currentVolume >= volumeToDrink;
    }

}
