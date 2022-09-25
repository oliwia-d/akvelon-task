package pl.akvelon.akvelontask.model.container.bottle;

import lombok.*;
import pl.akvelon.akvelontask.model.container.ContainerDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BottleDto extends ContainerDto {

    private Long id;

    public static BottleDto of(Bottle bottle) {
        BottleDto result = BottleDto.builder()
                .id(bottle.getId())
                .build();
        result.apply(bottle);
        return result;
    }

}
