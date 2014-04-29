package runnable;

import java.util.concurrent.TimeUnit;
import holders.HashMapHolder;

/**
 * Created by admin on 4/17/14.
 */
public class ReaderWorker implements Runnable {

    private static int count = 0;
    private final int id = count++;

    HashMapHolder mapHolder;

    public ReaderWorker(HashMapHolder mapHolder){
        this.mapHolder = mapHolder;
    }

    public void run(){
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                mapHolder.read();
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
