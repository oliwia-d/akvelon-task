package pl.akvelon.akvelontask.model.container;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContainerDto {

    private Integer currentVolume;
    private Integer maxVolume;
    private ContainerType type;

    public void apply(Container container) {
        this.currentVolume = container.getCurrentVolume();
        this.maxVolume = container.getMaxVolume();
        this.type = container.getType();
    }

}
