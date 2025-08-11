package study.effective_java.ch04_클래스와_인터페이스.item18;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class InstrumentedSet<E> extends AbstractSet<E> {
    private final Set<E> set;
    private int addCount = 0;

    public InstrumentedSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    @Override
    public Iterator<E> iterator() { return set.iterator(); }
    @Override
    public int size() { return set.size(); }
}
