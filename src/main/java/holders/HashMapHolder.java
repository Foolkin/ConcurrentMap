package holders;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * This class contains a HashMap and a methods to manipulate the contents of.
 */
public class HashMapHolder {

    /**
     * Map<Integer, Double>.
     */
    protected Map<Integer, Double> map;

    /**
     * Random used for getting random values.
     */
    Random random = new Random();

    /**
     * Constructor.
     * Initialize map like HashMap.
     * Put in map 10 elements with value 0.
     */
    public HashMapHolder(){
        map = new HashMap<Integer, Double>();
        initMap(10, 0);
    }

    /**
     * Constructor.
     * Initialize map like HashMap.
     * Fills map depending on parameters
     * @param size map size
     * @param initValue value
     */
    public HashMapHolder(int size, double initValue){
        map = new HashMap<Integer, Double>();
        initMap(size, initValue);
    }

    /**
     * Add and subtract a value from one key to other.
     * @param fromKey key from where will subtract value
     * @param toKey key in which will add value
     * @param value value which will add and subtract
     */
    public void transfer(int fromKey, int toKey, double value){
        if(map.get(fromKey) < value) return;

        map.put(fromKey, map.get(fromKey) - value);
        System.out.printf("  %5.2f | from %d  | to %d", value, fromKey, toKey);
        Thread.yield();
        map.put(toKey, map.get(toKey) + value);
        System.out.printf(" Summary: %5.2f %n", getSumValues());
    }

    /**
     * Put in a map random values
     */
    public void putRandom(){
        System.out.println("put");
        map.put(random.nextInt(), random.nextDouble());
        Thread.yield();
    }

    /**
     * Using iterator to read map Entry
     * TimeUnit.Milliseconds.sleep(10) used to increase ConcurentModification error
     */
    public void read(){
        Iterator it = map.entrySet().iterator();
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

    /**
     * Summarize all map values.
     * The sum should always be the same
     * @return sum of values
     */
    public double getSumValues(){
        double sum = 0;
        for(int key : map.keySet()){
            sum += map.get(key);
        }
        return sum;
    }

    /**
     * Initialize the map keys from 0 to size.
     * @param size number of keys
     * @param value key value
     */
    public void initMap(int size, double value){
        for(int i = 0; i < size; i++){
            map.put(i, value);
        }
    }

    /**
     * Sets map. Map <Integer, Double>
     * @param map Map object.
     */
    public void setMap(Map<Integer, Double> map){
        this.map = map;
    }

    /**
     * Returns map.
     * @return Map object.
     */
    public Map<Integer, Double> getMap(){
        return map;
    }
}
