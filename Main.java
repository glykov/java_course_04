import java.util.*;
import java.util.stream.*;

public class Main {
    public static List<Integer> getPortion(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) arr[i] += 1;
            if (i >= 2 && i <= 6) result.add(arr[i]);
        }

        return result;
    }

    public static List<Integer> getPortionStream(int[] arr) {
        return Arrays.stream(arr)
            .map(item -> item + 1 - (item & 1))
            .skip(2)
            .limit(7 -2)
            .boxed()
            .collect(Collectors.toList());
    }

    public static void main(String... args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(getPortion(array));
        System.out.println(getPortionStream(array));
    }
}