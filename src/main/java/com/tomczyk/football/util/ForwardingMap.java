package com.tomczyk.football.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Decorator pattern implementation for the Map.
 * 
 * Instead using a inheritance we use composition and forwarding.
 * 
 * In Java all Maps classes are final which means that we cannot extend them.
 * If we need something special or non-available (non-standard) in default implementations
 * we have to create a new class implementing the Map interface and implement all necessary
 * methods. This is not always a good idea.
 * 
 * Instead we can use ForwardingMap which internally implements Map but
 * it delegates to the 'internal' map.
 * 
 * This gives us the possibility of creating a new Map by extending the
 * ForwardingMap abstract class but in this case we do not have to implement
 * all methods but only selected of them.
 *
 * @param <K>
 * @param <V>
 */
public abstract class ForwardingMap<K, V> implements Map<K, V> {

    protected abstract Map<K, V> delegate();
    
    @Override
    public void clear() {
        delegate().clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate().containsValue(value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override
    public V get(Object key) {
        return delegate().get(key);
    }

    @Override
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override
    public V put(K key, V value) {
        return delegate().put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        delegate().putAll(m);
    }

    @Override
    public V remove(Object key) {
        return delegate().remove(key);
    }

    @Override
    public int size() {
        return delegate().size();
    }

    @Override
    public Collection<V> values() {
        return delegate().values();
    }
    
    @Override
    public boolean equals(Object obj) {
        return delegate().equals(obj);
    }
    
    @Override
    public int hashCode() {
        return delegate().hashCode();
    }
    
    public String toString() {
        return delegate().toString();
    }

}
