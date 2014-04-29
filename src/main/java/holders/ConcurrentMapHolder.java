package holders;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class contains a ConcurrentMap and a methods to manipulate the contents of.
 * Methods synchronized by Lock object.
 */
public class ConcurrentMapHolder extends HashMapHolder {

    /**
     * Lock object, that used to prevent data corruption.
     */
    private Lock lock = new ReentrantLock();

    /**
     * Constructor.
     * Initialize map like ConcurrentHashMap.
     * Put in map 10 elements with value 0.
     */
    public ConcurrentMapHolder (){
        map = new ConcurrentHashMap<Integer, Double>();
        initMap(10, 0);
    }

    /**
     * Constructor.
     * Initialize map like ConcurrentHashMap.
     * Fills map depending on parameters
     * @param size map size
     * @param initValue value
     */
    public ConcurrentMapHolder (int size, double initValue){
        map = new ConcurrentHashMap<Integer, Double>();
        initMap(size, initValue);
    }

    /**
     * Add and subtract a value from one key to other.
     * Using Lock object for synchronization.
     * @param fromKey key from where will subtract value
     * @param toKey key in which will add value
     * @param value value which will add and subtract
     */
    @Override
    public void transfer(int fromKey, int toKey, double value){

        lock.lock();
        try {
            if (map.get(fromKey) < value) return;

            map.put(fromKey, map.get(fromKey) - value);
            System.out.printf("  %5.2f | from %d  | to %d", value, fromKey, toKey);
            Thread.yield();
            map.put(toKey, map.get(toKey) + value);
            System.out.printf(" Summary: %5.2f %n", getSumValues());
        } finally {
            lock.unlock();
        }

    }
}
