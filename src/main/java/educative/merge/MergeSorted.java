package educative.merge;

public class MergeSorted {
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int[] list = new int[m+n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                list[i+j] = nums1[i];
                i++;
            } else {
                list[i+j] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            list[i+j] = nums1[i];
            i++;
        }
        while (j < n) {
            list[i+j] = nums2[j];
            j++;
        }

        return list;
    }

    public static int[] inPlaceMergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1 -= 1;
            }
            else {
                nums1[p] = nums2[p2];
                p2 -= 1;
            }
        }
        return nums1;
    }
}
