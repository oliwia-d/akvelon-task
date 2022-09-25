package pl.akvelon.akvelontask.model.creature.man;

import lombok.*;
import pl.akvelon.akvelontask.model.creature.CreatureDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManDto extends CreatureDto {

    private Long id;

    public static ManDto of(Man man) {
        ManDto result = ManDto.builder()
                .id(man.getId())
                .build();
        result.apply(man);
        return result;
    }

}
