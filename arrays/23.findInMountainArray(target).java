class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

       
        int peak = findPeak(mountainArr);

       
        int left = binarySearchAsc(mountainArr, target, 0, peak);
        if (left != -1) return left;

        return binarySearchDesc(mountainArr, target, peak + 1, n - 1);
    }

    private int findPeak(MountainArray arr) {
        int low = 0, high = arr.length() - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearchAsc(MountainArray arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private int binarySearchDesc(MountainArray arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;
            else if (val > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
