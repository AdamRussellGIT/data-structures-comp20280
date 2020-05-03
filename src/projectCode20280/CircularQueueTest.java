package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularQueueTest {

    @Test
    void testSize() {
        CircularQueue<Integer> s = new CircularQueue<>();
        for(int i = 0; i < 10; ++i)
            s.enqueue(i);
        assertEquals(10, s.size());
    }

    @Test
    void testIsEmpty() {
        CircularQueue<Integer> s = new CircularQueue<>();
        for(int i = 0; i < 10; ++i)
            s.enqueue(i);
        for(int i = 0; i < 10; ++i)
            s.dequeue();
        assertEquals(true, s.isEmpty());
    }

    @Test
    void testEnqueue() {
        CircularQueue<Integer> s = new CircularQueue<>();
        for(int i = 0; i < 10; ++i)
            s.enqueue(i);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", s.toString());
    }

    @Test
    void testFirst() {
        CircularQueue<Integer> s = new CircularQueue<>();
        for(int i = 0; i < 10; ++i)
            s.enqueue(i);
        assertEquals(0, s.first());
    }

    @Test
    void testDequeue() {
        CircularQueue<Integer> s = new CircularQueue<>();
        for(int i = 0; i < 10; ++i)
            s.enqueue(i);

        assertEquals(0, s.dequeue());
        assertEquals(9, s.size());
    }

}
