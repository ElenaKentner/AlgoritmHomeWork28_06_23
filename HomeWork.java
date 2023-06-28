package _2023_06_28;

public class HomeWork {
    public static void main(String[] args) {
        //разбор дз - принцип разделяй и властвуй
        /*
        Task 1. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
        который будет находиться на k-й позиции в конечном отсортированном массиве.
         */
        int[] arr1 = {1, 3, 5, 9};
        int[] arr2 = {4, 7};
        System.out.println(findNumber(arr1, arr2, 3));

        System.out.println(binarySearchRec(arr1, 5));
    }

    private static int findNumber(int[] arr1, int[] arr2, int k) {
        int len1 = arr1.length; //переменные для длины каждого массива для удобства
        int len2 = arr2.length;
        if (k < 0 || k > len1 + len2) { //проверка что число искомое в пределах массива
            System.out.println("Error");
            return -1;
        }
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                if (i + j == k) {
                    return arr1[i];
                } else {
                    i++;
                }
            } else {
                if (i + j == k) {
                    return arr2[j];
                } else {
                    j++;
                }
            }
        }
        while (i < len1) {
            if (i + j == k) {
                return arr1[i];
            } else {
                i++;
            }
        }
        while (j < len2) {
            if (i + j == k) {
                return arr2[j];
            } else {
                j++;
            }
        }
        return -1;
    }
/*
Task 2. Реализовать рекурсивный алгоритм бинарного поиска. Используйте стратегию "разделяй и властвуй".
 */
    //рекрусивная реализация
    public static int binarySearchRec(int[] arr, int target) {
        return binarySearchRec(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRec(int[] arr, int target, int left, int right) {
        //базовый случай - число не найдено(его там нет)
        if (left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRec(arr, target, mid + 1, right);
        } else {
            return binarySearchRec(arr, target, left, mid - 1);
        }
    }
}
