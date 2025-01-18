import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<T extends Comparable<T>> {
    private T[] array;
    private int size;


    public MyArrayList() {
        array = (T[]) new Comparable[10]; // Начальная емкость массива
        size = 0;
    }


    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }


    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Помощь сборщику мусора
        return removedElement;
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }


    public void sort(Comparator<? super T> comparator) {
        quicksort(0, size - 1, comparator);
    }


    private void quicksort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }


    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0){
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }


    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private void ensureCapacity() {
        if (size == array.length){
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}