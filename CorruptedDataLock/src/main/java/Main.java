/**
 *
 * Trying to corrupt map data with method, that use Lock object to synchronize.
 * Field summary in output should be the same.
 */
public class Main {
    public static void main(String[] args){
        CorrupterData corrupterData = new CorrupterData();

        corrupterData.corruptLockHashMap();
    }
}