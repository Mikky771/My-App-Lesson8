package app;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[15];
        Random random = new Random();

        // Заповнюємо масив випадковими числами від 1 до 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // nextInt(100) дає числа від 0 до 99, додаємо 1 для діапазону 1-100
        }

        // Виведення початкового вигляду масиву
        System.out.println("Початковий масив:");
        System.out.println(Arrays.toString(array));

        // Сортування масиву за допомогою алгоритму сортування вставкою
        insertionSort(array);

        // Виведення відсортованого масиву
        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));

        // Запит числа для пошуку
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();

        // Бінарний пошук числа в масиві
        int index = binarySearch(array, target);

        // Виведення результату пошуку
        if (index == -1) {
            System.out.println("Число " + target + " не знайдено в масиві.");
        } else {
            System.out.println("Число " + target + " знайдено в масиві на індексі " + index + ".");
        }
    }

    // Метод сортування вставкою
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Зсуваємо елементи масиву, які більше ключа, на одну позицію вправо
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Вставляємо ключ на своє місце
            array[j + 1] = key;
        }
    }

    // Метод для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Перевірка, чи є середній елемент шуканим числом
            if (array[mid] == target) {
                return mid;
            }

            // Якщо шукане число більше за середній елемент, шукаємо у правій частині
            if (array[mid] < target) {
                left = mid + 1;
            } else { // Інакше шукаємо у лівій частині
                right = mid - 1;
            }
        }

        // Число не знайдено
        return -1;
    }
}
