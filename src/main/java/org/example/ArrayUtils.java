package org.example;

public class ArrayUtils {
  public static void bubbleSort(Integer[] data) {
    int n = data.length;
    for (int j = 1; j < n; j++) {
      boolean isSorted = true;
      for (int i = 0; i < n - j; i++) {
        if (data[i] > data[i + 1]) {
          int tmp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = tmp;
          isSorted = false;
        }
      }
      if (isSorted) {
        break;
      }
    }
  }

  public static void selectionSort(Integer[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minValue = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = i; j < n; j++) {
        if (arr[j] < minValue) {
          minValue = arr[j];
          minIndex = j;
        }
      }
      int tmp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = tmp;
    }
  }

  public static int partition(Integer[] arr, int low, int high)
  {
    int pivot = arr[high];
    int i = (low-1); // index of smaller element
    for (int j=low; j < high; j++)
    {
      // If current element is smaller than or
      // equal to pivot
      if (arr[j] <= pivot)
      {
        i++;

        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;
  }

  public static void quickSort(Integer[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public static void quickSort(Integer[] arr, int low, int high)
  {
    if (low < high)
    {
            /* pi is partitioning index, arr[pi] is
              now at right place */
      int pi = partition(arr, low, high);

      // Recursively sort elements before
      // partition and after partition
      quickSort(arr, low, pi-1);
      quickSort(arr, pi+1, high);
    }
  }
}
