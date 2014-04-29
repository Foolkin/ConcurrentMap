/**
 * Trying to crash work of ConcurrentHashMap .
 */
public class Main {
    public static void main(String[] args){
        MapCrusher mapCrasher = new MapCrusher();

        mapCrasher.tryCrashConcurrentHolder();
    }
}