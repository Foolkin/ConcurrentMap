package runnable;

import holders.HashMapHolder;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 4/17/14.
 */
public class PutterWorker implements Runnable {

    private static int count = 0;
    private final int id = count++;

    HashMapHolder mapHolder;

    public PutterWorker(HashMapHolder mapHolder, int size){
        this.mapHolder = mapHolder;
    }

    public void run(){
        try{
            while (true) {
                TimeUnit.MILLISECONDS.sleep(1000);
                mapHolder.putRandom();
            }

        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
