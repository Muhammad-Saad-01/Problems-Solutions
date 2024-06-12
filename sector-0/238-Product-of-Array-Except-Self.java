import java.util.*;


class Solution {
    public int[] productExceptSelf(int[] nums) {
       // Calculate the product of all non-zero elements and count the zeros
        Map<String, Integer> productAndZeroCount = Arrays.stream(nums)
                .boxed() // to Convert int to Integer, generally .boxed() used to convert to wrapper classes
                .collect(Collectors.teeing(
                        Collectors.filtering(num -> num != 0, Collectors.reducing(1, (a, b) -> a * b)),
                        Collectors.summingInt(num -> num == 0 ? 1 : 0),
                        (product, zeroCount) -> Map.of(\product\, product, \zeroCount\, zeroCount)
                ));

        int product = productAndZeroCount.get(\product\);
        int zeroCount = productAndZeroCount.get(\zeroCount\);

        // Calculate the result based on the product and zero count
        return Arrays.stream(nums).map(num -> {
            if (zeroCount > 1) {
                return 0;
            } else if (zeroCount == 1) {
                return num == 0 ? product : 0;
            } else {
                return product / num;
            }
        }).toArray();
    }
}