package grokkingalgorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};
        BinarySearch bSearch = new BinarySearch();

        if (bSearch.binarySearch(myList, 3) == -1) {
            System.out.println("3 is not in the list.");
        } else {
            System.out.println("3 is in the list.");
        }

        if (bSearch.binarySearch(myList, -1) == -1) {
            System.out.println("-1 is not in the list.");
        } else {
            System.out.println("-1 is in the list.");
        }
    }

    public int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
