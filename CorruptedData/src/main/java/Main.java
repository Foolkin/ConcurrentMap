/**
 * Trying to corrupt HashMap data without synchronization.
 * Field summary in output should be the same.
 */
public class Main {
    public static void main(String[] args){
        CorrupterData corrupterData = new CorrupterData();

        corrupterData.corruptHashMap();
    }
}