import holders.ConcurrentMapHolder;
import holders.HashMapHolder;
import holders.SyncMapHolder;
import runnable.TransferWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class contains methods that use a different map holders and trying to cause data corruption.
 */
public class CorrupterData {

    /**
     * Number of map elements.
     */
    private static final int SIZE = 25;

    /**
     * Initial value of map for all elements
     */
    private static final int INITIAL_VALUE = 1000;

    /**
     * Number of thread that will be used.
     */
    private static final int THREAD_COUNT = 25;

    /**
     * Trying to corrupt map data without synchronization.
     */
    public void corruptHashMap(){
        HashMapHolder mapHolder = new HashMapHolder(SIZE, INITIAL_VALUE);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(new TransferWorker(mapHolder, i, INITIAL_VALUE));
        }
        executor.shutdown();
    }

    /**
     * Trying to corrupt map data with synchronized method.
     */
    public void corruptSyncHashMap(){
        HashMapHolder mapHolder = new SyncMapHolder(SIZE, INITIAL_VALUE);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(new TransferWorker(mapHolder, i, INITIAL_VALUE));
        }
        executor.shutdown();
    }

    /**
     * Trying to corrupt map data with method, that use Lock object to synchronize.
     */
    public void corruptLockHashMap(){
        HashMapHolder mapHolder = new ConcurrentMapHolder(SIZE, INITIAL_VALUE);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(new TransferWorker(mapHolder, i, INITIAL_VALUE));
        }
        executor.shutdown();
    }


}
