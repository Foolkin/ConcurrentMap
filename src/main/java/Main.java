/**
 * Created by admin on 4/17/14.
 */
public class Main {
    public static void main(String[] args){
        MapCrusher mapCrasher = new MapCrusher();
        CorrupterData corrupterData = new CorrupterData();

//        mapCrasher.tryCrashHashMapHolder();             //use general HashMap for multithreading put and remove operations

//        mapCrasher.tryCrashSyncHolder();               //use Collections.synchronizedMap for multithreading put and remove operations

//        mapCrasher.tryCrashConcurrentHolder();         //use ConcurrentHashMap for multithreading put and remove operations

//        corrupterData.corruptHashMapHolder();           //use for multithreading change HashMap values without synchronization

//        corrupterData.corruptConcurrentMapHolder();     //use for multithreading change HashMap values with Lock object to synchronize

//        corrupterData.corruptSyncMapHolder();           //use for multithreading change HashMap values with synchronyzed keyword to synchronize

    }
}
