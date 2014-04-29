package holders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This class contains a Collections.synchronizedMap and a methods to manipulate the contents of.
 * Methods synchronized by synchronized keyword.
 */
public class SyncMapHolder extends HashMapHolder {

    /**
     * synchronizedMap.
     */
    private Map syncMap;

    /**
     * Constructor.
     * Initialize syncMap like Collection.synchronizedMap.
     * Put in map 10 elements with value 0.
     */
    public SyncMapHolder() {
        super();
        syncMap = Collections.synchronizedMap(new HashMap());
    }

    /**
     * Constructor.
     * Initialize map like ConcurrentHashMap.
     * Fills map depending on parameters
     * @param size map size
     * @param initValue value
     */
    public SyncMapHolder(int size, double initValue) {
        super(size, initValue);
        syncMap = Collections.synchronizedMap(map);
    }



    /**
     * Add and subtract a value from one key to other.
     * Synchronized
     * @param fromKey key from where will subtract value
     * @param toKey key in which will add value
     * @param value value which will add and subtract
     */
    @Override
    public synchronized void transfer(int fromKey, int toKey, double value) {
        if (map.get(fromKey) < value) return;

        map.put(fromKey, map.get(fromKey) - value);
        System.out.printf("  %5.2f | from %d  | to %d", value, fromKey, toKey);
        Thread.yield();
        map.put(toKey, map.get(toKey) + value);
        System.out.printf(" Summary: %5.2f %n", getSumValues());
//            read();
    }


    /**
     * Put in a map random values
     */
    @Override
    public synchronized void putRandom(){
        syncMap.put(random.nextInt(), random.nextDouble());
        Thread.yield();
        System.out.println("put");
    }

    /**
     * Using iterator read all map
     */
    @Override
    public synchronized void read() {
        Iterator it = syncMap.entrySet().iterator();
        if(it.hasNext()) {
            Thread.yield();
            it.next();
            System.out.println("read");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            it.next();
        }
    }

    public static void main(String[] args) {
        SyncMapHolder syncMap = new SyncMapHolder();
        System.out.println(syncMap.getMap());
    }
}

