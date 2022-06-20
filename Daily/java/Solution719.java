import java.util.Arrays;

/**
 * 寻找第k小的数对距离
 * hard
 */
class Solution719 {
    public int mySmallestDistancePair(int[] nums, int k) {
        /**
         * 我的思路
         * 1、每次找到一对距离就塞入有序列表
         * 2、取出有序列表的第k个元素
         *
         * 事实证明，暴力算法不可取，资源瓶颈了
         */
        int n = nums.length;
        int[] sortedDis = new int[n * (n - 1) / 2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++, cnt++) {
                int numi = nums[i];
                int numj = nums[j];
                int distance = Math.abs(numi - numj);
                sortedDis[cnt] = distance;
            }
        }
        Arrays.sort(sortedDis);
        return sortedDis[k-1];
    }

    public int smallestDistancePair(int[] nums, int k) {
        /**
         * 正解思路
         * 双指针滑动窗口+二分法
         * 1、排序nums后得到距离数组
         * 2、第k个肯定在最大距离和最小距离之间
         * 3、滑动窗口得到小于mid的数对个数
         * 4、直到找到最终的数字
         */
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        while (left < right) {
            int mid = (right + left) / 2;
            int count = countPair(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 最后 left = right
        return left;
    }

    /**
     * 滑动窗口获取对数
     */
    private int countPair(int[] nums, int limit) {
        int length = nums.length;

        int count = 0;
        for (int left = 0,right = 0;right < length; right++) {
            while (nums[right] - nums[left] > limit) {
                left++;
            }
            // 如果<=limit，表示nums[left]到nums[right]之间的数对都<=limit
            // nums[0]和nums[2]之间有数对（0，2），（1，2）总共两对
            count += right - left;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution719 solution = new Solution719();
        int k = 2;
        int[] nums = new int[]{2,2,0,1,1,0,0,1,2,0};
        int res = solution.smallestDistancePair(nums, k);
        System.out.println("第"+k+"小数字为"+res);
    }
}

// 0 1 1 1 2 1 0 0 2 1 1 1 2 1 0 0 1 1 0 0 0 1 0 0 0 1 0 0 1 1 1 0 0 1 0 0 1 0 0 1 0 0 1 1 2