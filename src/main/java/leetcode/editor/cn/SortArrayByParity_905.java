package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] example) {
        if (null == example || 2 > example.length) {
            return example;
        }
        int first = 0;
        int second = example.length - 1;
        while (first < second) {
            while ((example[first] & 1) == 0 && first < second) {
                first++;
            }
            while ((example[second] & 1) == 1 && first < second) {
                second--;
            }
            int temp = example[first];
            example[first] = example[second];
            example[second] = temp;
        }
        return example;
    }

    @Test
    public void testSortArrayByParity() {
        int[] example = new int[]{1, 2, 3, 4};
        Assert.assertArrayEquals(sortArrayByParity(example), new int[]{4, 2, 3, 1});
        example = new int[]{2, 1};
        Assert.assertArrayEquals(sortArrayByParity(example), new int[]{2, 1});
        example = new int[]{};
        Assert.assertArrayEquals(sortArrayByParity(example), new int[]{});
    }
}
