package study.effective;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class EventPublisher {

    private final List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener) {
        listeners.add(listener);
    }
}
