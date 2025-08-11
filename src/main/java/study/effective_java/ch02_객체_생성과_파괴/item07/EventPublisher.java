package study.effective_java.ch02_객체_생성과_파괴.item07;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class EventPublisher {

    private final List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener) {
        listeners.add(listener);
    }
}
