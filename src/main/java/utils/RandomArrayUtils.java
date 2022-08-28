package utils;

import java.util.ArrayList;
import java.util.Random;
public class RandomArrayUtils {
    public static ArrayList<int[]>  getRandomArrayGroup( int capcity,int origin,int bound,int limit) {
        ArrayList<int[]> array = new ArrayList<int[]>();
        for (int i = 1; i <= capcity; i++) {
            array.add(new Random().ints(origin,bound).limit(limit).toArray());
        }
        return array;
    }
}
