package org.example.Algorithm.BinarySearch;

public class BinarySearch {
    /*
    바이토닉 정수 배열 arr가 주어졌을 때,
    그 배열의 가장 큰 수의 인덱스를 반환하는 메서드. 배열에 중복된 수는 없다고 가정한다.
    ex. arr = {1, 2, 4, 6, 3, 2} -> return : 3
     */
    static int binarySearchPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return low;
    }

    /*
    단조 증가 정수 배열 arr와 찾고 싶은 정수 key가 주어졌을 때,
    배열에 key가 있으면 key가 마지막으로 나타나는 인덱스에 1을 더해서 반환하고,
    배열에 key가 없으면 key보다 큰 수 중 가장 왼쪽에 있는 수의 인덱스를 반환한다.
    ex. arr = {1, 2, 2, 3, 4, 5}, key = 2 -> return : 3
     */
    static int binarySearchUpperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    /*
    단조 증가 정수 배열 arr와 찾고 싶은 정수 key가 주어졌을 때,
    배열에 key가 있으면 key가 처음으로 나타나는 인덱스를 반환하고,
    배열에 key가 없으면 key보자 작은 수 중 가장 오른쪽에 있는 수의 인덱스에 1을 더해서 반환한다.
    ex. arr = {1, 2, 2, 3, 4, 5}, key = 2 -> return : 1
     */
    static int binarySearchLowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < key) low = mid + 1;
            else high = mid;
        }
        return low;

    }
}
