/**
 * Trying to corrupt map data with synchronized method.
 * Field summary in output should be the same.
 */
public class Main {
    public static void main(String[] args){
        CorrupterData corrupterData = new CorrupterData();

        corrupterData.corruptSyncHashMap();
    }
}