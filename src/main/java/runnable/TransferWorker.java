package runnable;

import holders.HashMapHolder;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 4/17/14.
 */
public class TransferWorker implements Runnable{

    HashMapHolder mapHolder;
    int fromKey;
    int maxValue;

    public TransferWorker(HashMapHolder mapHolder, int from, int maxValue){
        this.mapHolder = mapHolder;
        this.fromKey = from;
        this.maxValue = maxValue;
    }

    public void run(){
        try{
            while (true){
                int toKey = (int) (Math.random() * mapHolder.getMap().size());
                double value = maxValue * Math.random();
                mapHolder.transfer(fromKey, toKey, value);
//                mapHolder.read();
                TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
