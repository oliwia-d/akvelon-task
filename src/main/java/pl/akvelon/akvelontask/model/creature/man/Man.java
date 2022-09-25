package pl.akvelon.akvelontask.model.creature.man;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.akvelon.akvelontask.model.creature.Creature;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Table
@Entity
@SuperBuilder
@NoArgsConstructor
public class Man extends Creature {

}
