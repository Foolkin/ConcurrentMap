import holders.ConcurrentMapHolder;
import holders.HashMapHolder;
import holders.SyncMapHolder;
import runnable.PutterWorker;
import runnable.ReaderWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * /**
 * This class contains methods that use a different map holders
 * and trying to cause crash of HashMap work, using put and remove operations.
 */
public class MapCrusher {

    /**
     * Executor that execute a number of threads.
     */
    ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Trying to crash work of HashMap .
     */
    public void tryCrashHashMapHolder() {
        HashMapHolder mapHolder = new HashMapHolder();
        for (int i = 0; i < 10; i++) {
            executor.execute(new PutterWorker(mapHolder, 20));
            executor.execute(new ReaderWorker(mapHolder));
        }
        executor.shutdown();
    }

    /**
     * Trying to crash work of Collections.synchronizedMap .
     */
    public void tryCrashSyncHolder() {
        HashMapHolder mapHolder = new SyncMapHolder();
        for (int i = 0; i < 10; i++) {
            executor.execute(new PutterWorker(mapHolder, 20));
            executor.execute(new ReaderWorker(mapHolder));

        }
        executor.shutdown();
    }

    /**
     * Trying to crash work of ConcurrentHashMap .
     */
    public void tryCrashConcurrentHolder() {
        HashMapHolder mapHolder = new ConcurrentMapHolder();
        for (int i = 0; i < 10; i++) {
            executor.execute(new PutterWorker(mapHolder, 20));
            executor.execute(new ReaderWorker(mapHolder));
        }
        executor.shutdown();
    }


}
