package coding_test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class 카카오_가을_인턴_1 {
    /*
     * Complete the 'priceCheck' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. FLOAT_ARRAY productPrices
     *  3. STRING_ARRAY productSold
     *  4. FLOAT_ARRAY soldPrice
     */
    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here
        int[] check = new int[productSold.size()];

        int index = 0;
        for (int i = 0; i < productSold.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (productSold.get(i).equals(products.get(j))) {
                    check[index] = j;
                    index++;
                    continue;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < soldPrice.size(); i++) {
            if (soldPrice.get(i) - productPrices.get(check[i]) != 0) {
                ans++;
            }
        }

        return ans;
    }

}


