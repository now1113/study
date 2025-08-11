package study.effective_java.연습.item47;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Adapter {

    // Iterable -> Stream
    public static <T> Stream<T> streamOf(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    // Stream -> Iterable
    public static <T> Iterable<T> iterableOf(Stream<T> stream) {
        return stream::iterator;
    }

    // Iterator -> Stream (크기 미상)
    public static <T> Stream<T> streamOf(Iterator<T> iterator) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }
}
