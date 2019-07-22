package ru.job4j.array;

public class FindLoop {
    /**
     * Метод определяет и возвращает индекс элемента в массиве
     * @param data Массив, в котором находится искомый элемент
     * @param el Элемент, индекс которого нужен
     * @return int индекс элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод определяет и возвращает индекс элемента в определённом промежутке массива
     * @param data Массив, в котором находится искомый элемент
     * @param el Элемент, индекс которого нужен
     * @param start Индекс, с которого начинается поиск. Т.е. левая граница
     * @param finish Индекс, которым заканчивается поиск. Т.е правая граница
     * @return int индекс элемента
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод сортирует массив в порядке возростания
     * @param data Массив, подлежащий сортировке
     * @return int[] отсортированый массив
     */
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                }
            }
            int minIndex = indexOf(data, min, i, data.length - 1);
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }
}