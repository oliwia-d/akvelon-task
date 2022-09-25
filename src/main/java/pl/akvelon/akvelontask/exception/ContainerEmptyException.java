package pl.akvelon.akvelontask.exception;

import pl.akvelon.akvelontask.model.container.Container;

public class ContainerEmptyException extends RuntimeException {

    public static final String MESSAGE_FORMAT = "The volume %d exceeds current volume of dish: %d.";
    public ContainerEmptyException(Container container, int volume) {
        super(String.format(MESSAGE_FORMAT, volume, container.getMaxVolume() - container.getCurrentVolume()));
    }
}
