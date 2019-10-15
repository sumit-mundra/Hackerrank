package algorithms;

public class MergeSort {
}

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        // return mergeSort(nums, 0, nums.length - 1);
        bottomUpIterative(nums);
        return nums;
    }

    public int[] mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int[] left = mergeSort(nums, start, mid);
            int[] right = mergeSort(nums, mid + 1, end);
            return merge(left, right);
        } else {
            return new int[]{nums[start]};
        }
    }

    public int[] merge(int[] left, int[] right) {
        int res_cur = 0;
        int left_cur = 0;
        int right_cur = 0;

        int[] result = new int[left.length + right.length];
        while (left_cur < left.length && right_cur < right.length) {
            if (left[left_cur] < right[right_cur]) {
                result[res_cur++] = left[left_cur++];
            } else {
                result[res_cur++] = right[right_cur++];
            }
        }
        while (left_cur < left.length) {
            result[res_cur++] = left[left_cur++];
        }
        while (right_cur < right.length) {
            result[res_cur++] = right[right_cur++];
        }
        return result;
    }


    public void mergeI(int[] nums, int left, int lleft, int lright) {
        int res_cur = 0;
        int left_cur = left;
        int right = left + lleft;
        int rightMax = right + lright;
        int right_cur = right;

        int[] result = new int[lleft + lright];
        while (left_cur < right && right_cur < rightMax) {
            if (nums[left_cur] < nums[right_cur]) {
                result[res_cur++] = nums[left_cur++];
            } else {
                result[res_cur++] = nums[right_cur++];
            }
        }
        while (left_cur < right) {
            result[res_cur++] = nums[left_cur++];
        }
        while (right_cur < right + lright) {
            result[res_cur++] = nums[right_cur++];
        }
        res_cur = 0;
        while (res_cur < lleft + lright) {
            nums[res_cur + left] = result[res_cur];
            res_cur++;
        }
    }

    public void bottomUpIterative(int[] nums) {
        int lleft = 1;
        int n = nums.length;
        while (lleft < n) {
            int i = 0;
            while (i < n) {
                int lright = lleft;
                if (i + lleft + lright > n) {
                    lright = n - (i + lleft);
                }
                mergeI(nums, i, lleft, lright);
                i = i + lleft + lright;
            }
            lleft = 2 * lleft;
        }
    }

}
