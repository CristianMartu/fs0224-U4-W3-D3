package cristianmartucci.exceptions;

import java.util.UUID;

public class EventException extends RuntimeException {
    public EventException(UUID id) {
        super("Nessun elemento trovato con id: " + id);
    }
}
