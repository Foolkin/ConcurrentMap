/**
 * Trying to crash work of Collections.synchronizedMap .
 */
public class Main {
    public static void main(String[] args){
        MapCrusher mapCrasher = new MapCrusher();

        mapCrasher.tryCrashSyncHolder();
    }
}