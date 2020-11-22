import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ImmutableMapTest {

    public static final String KEY_A = "keyA";
    public static final String VALUE_A = "valueA";
    public static final String KEY_B = "keyB";
    public static final String VALUE_B = "valueB";

    @Test(expected = IllegalArgumentException.class)
    public void nullSourceTest() {
        new ImmutableMap<>(null);
    }

    @Test
    public void sizeTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertEquals(0, immutableMap.size());
        map.put(KEY_A, VALUE_A);
        assertEquals(0, immutableMap.size());
        immutableMap = new ImmutableMap<>(map);
        assertEquals(1, immutableMap.size());
        map.put(KEY_B, VALUE_B);
        immutableMap = new ImmutableMap<>(map);
        assertEquals(2, immutableMap.size());
    }

    @Test
    public void changeSourceTest() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_A, VALUE_A);
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        map.put(KEY_B, VALUE_B);
        assertEquals(1, immutableMap.size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(1, immutableMap.entrySet().size());
        assertTrue(immutableMap.entrySet().contains(Map.entry(KEY_A, VALUE_A)));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(2, immutableMap.size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(VALUE_B, immutableMap.get(KEY_B));
        assertEquals(2, immutableMap.entrySet().size());
        assertTrue(immutableMap.entrySet().contains(Map.entry(KEY_A, VALUE_A)));
        assertTrue(immutableMap.entrySet().contains(Map.entry(KEY_B, VALUE_B)));
    }

    @Test
    public void isEmptyTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertTrue(immutableMap.isEmpty());
        map.put(KEY_A, VALUE_A);
        assertTrue(immutableMap.isEmpty());
        immutableMap = new ImmutableMap<>(map);
        assertFalse(immutableMap.isEmpty());
        map.put(KEY_B, VALUE_B);
        immutableMap = new ImmutableMap<>(map);
        assertFalse(immutableMap.isEmpty());
    }

    @Test
    public void containsKeyTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertFalse(immutableMap.containsKey(KEY_A));
        map.put(KEY_A, VALUE_A);
        assertFalse(immutableMap.containsKey(KEY_A));
        immutableMap = new ImmutableMap<>(map);
        assertTrue(immutableMap.containsKey(KEY_A));
        map.put(KEY_B, VALUE_B);
        assertFalse(immutableMap.containsKey(KEY_B));
        immutableMap = new ImmutableMap<>(map);
        assertTrue(immutableMap.containsKey(KEY_A));
        assertTrue(immutableMap.containsKey(KEY_B));
    }

    @Test
    public void containsValueTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertFalse(immutableMap.containsValue(VALUE_A));
        map.put(KEY_A, VALUE_A);
        assertFalse(immutableMap.containsValue(VALUE_A));
        immutableMap = new ImmutableMap<>(map);
        assertTrue(immutableMap.containsValue(VALUE_A));
        map.put(KEY_B, VALUE_B);
        assertFalse(immutableMap.containsValue(VALUE_B));
        immutableMap = new ImmutableMap<>(map);
        assertTrue(immutableMap.containsValue(VALUE_A));
        assertTrue(immutableMap.containsValue(VALUE_B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putTest() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_A, VALUE_A);
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        immutableMap.put(KEY_B, VALUE_B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeTest() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_A, VALUE_A);
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        immutableMap.remove(KEY_B);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllTest() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_A, VALUE_A);
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        immutableMap.putAll(map);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clearTest() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY_A, VALUE_A);
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        immutableMap.clear();
    }


    @Test
    public void getTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertNull(immutableMap.get(KEY_A));
        map.put(KEY_A, VALUE_A);
        assertNull(immutableMap.get(KEY_A));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        map.put(KEY_B, VALUE_B);
        assertNull(immutableMap.get(KEY_B));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(VALUE_B, immutableMap.get(KEY_B));
    }

    @Test
    public void keySetTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertEquals(0, immutableMap.keySet().size());
        map.put(KEY_A, VALUE_A);
        assertEquals(0, immutableMap.keySet().size());
        immutableMap = new ImmutableMap<>(map);
        assertEquals(1, immutableMap.keySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        map.put(KEY_B, VALUE_B);
        assertEquals(1, immutableMap.keySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(2, immutableMap.keySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(VALUE_B, immutableMap.get(KEY_B));
    }

    @Test
    public void valuesTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertEquals(0, immutableMap.values().size());
        map.put(KEY_A, VALUE_A);
        assertEquals(0, immutableMap.values().size());
        immutableMap = new ImmutableMap<>(map);
        assertEquals(1, immutableMap.values().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        map.put(KEY_B, VALUE_B);
        assertEquals(1, immutableMap.values().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(2, immutableMap.values().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(VALUE_B, immutableMap.get(KEY_B));
    }

    @Test
    public void entrySetTest() {
        Map<String, String> map = new HashMap<>();
        ImmutableMap<String, String> immutableMap = new ImmutableMap<>(map);
        assertEquals(0, immutableMap.entrySet().size());
        map.put(KEY_A, VALUE_A);
        assertEquals(0, immutableMap.entrySet().size());
        immutableMap = new ImmutableMap<>(map);
        assertEquals(1, immutableMap.entrySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        map.put(KEY_B, VALUE_B);
        assertEquals(1, immutableMap.entrySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        immutableMap = new ImmutableMap<>(map);
        assertEquals(2, immutableMap.entrySet().size());
        assertEquals(VALUE_A, immutableMap.get(KEY_A));
        assertEquals(VALUE_B, immutableMap.get(KEY_B));
    }

}
