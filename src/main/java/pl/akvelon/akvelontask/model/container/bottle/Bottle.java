package pl.akvelon.akvelontask.model.container.bottle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.akvelon.akvelontask.model.container.Container;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Table
@Entity
@SuperBuilder
@NoArgsConstructor
public class Bottle extends Container {

}
