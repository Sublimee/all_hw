import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class ImmutableMap<K, V> implements Map<K, V> {

    private final Map<? extends K, ? extends V> internalMap;

    public ImmutableMap(Map<? extends K, ? extends V> map) {
        if (Objects.isNull(map)) {
            throw new IllegalArgumentException("null as argument not supported");
        }
        this.internalMap = map.entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    @Override
    public int size() {
        return internalMap.entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return internalMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        throw uoe();
    }

    @Override
    public V remove(Object key) {
        throw uoe();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw uoe();
    }

    @Override
    public void clear() {
        throw uoe();
    }

    @Override
    public Set<K> keySet() {
        return (Set<K>) internalMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return (Collection<V>) internalMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet().parallelStream()
                .map(x -> Map.entry((K) x.getKey(), (V) x.getValue()))
                .collect(Collectors.toSet());
    }

    private UnsupportedOperationException uoe() {
        return new UnsupportedOperationException();
    }

}
