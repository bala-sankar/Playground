package educative.modifiedbinarysearch;

public class FirstBadVersion {
    private static boolean isBadVersion(int version, int badVersion) {
        // Placeholder for the actual implementation
        return version < badVersion;
    }

    public static int[] firstBadVersion(int n, int badVersion) {
        int i = 1, j = n;
        int apiCalls = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            apiCalls++;
            if (isBadVersion(mid, badVersion)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }


        // Replace this placeholder return statement with your code
        return new int[]{badVersion, apiCalls};
    }

//    public static int[] firstBadVersion(int n) {
//        int i = 1, j = n;
//        int apiCalls = 0;
//        int badVersion = -1;
//        while (i <= j) {
//            int mid = i + (j - i) / 2;
//            apiCalls++;
//            if (isBadVersion(mid)) {
//                badVersion = mid;
//                j = mid - 1;
//            } else {
//                i = mid + 1;
//            }
//        }
//
//
//        // Replace this placeholder return statement with your code
//        return new int[]{badVersion, apiCalls};
//    }
}
