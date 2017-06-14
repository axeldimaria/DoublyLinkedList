import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by axelntwari on 6/14/17.
 */
public class TestDLinkedList {

    @Test
    public void isEmpty() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();
        assertTrue(a.isEmpty());
        a.add(10);
        assertFalse(a.isEmpty());
    }

    @Test
    public void add() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();
        a.add(10);
        assertTrue(a.search(10));
        assertFalse(a.search(15));
    }

    @Test
    public void size() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();
        a.add(1);
        a.add(100);

        int size = a.size();

        assertEquals(size, 2);
    }

    @Test
    public void search() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();

        assertFalse(a.search(15));

        a.add(10);
        assertTrue(a.search(10));
        assertFalse(a.search(15));
    }

    @Test
    public void remove() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();

        a.add(10);
        a.add(15);
        assertTrue(a.search(10));
        assertTrue(a.search(15));

        a.remove(15);
        assertTrue(a.search(10));
        assertFalse(a.search(15));

        a.remove(10);
        assertTrue(a.isEmpty());
    }

    @Test
    public void smartSearch() throws Exception {
        DLinkedList<Integer> a = new DLinkedList<>();

        assertFalse(a.search(15));

        a.add(10);
        assertTrue(a.search(10));
        assertFalse(a.search(15));
    }


}