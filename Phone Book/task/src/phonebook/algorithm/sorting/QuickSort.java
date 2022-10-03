package phonebook.algorithm.sorting;

import phonebook.model.Person;

import java.util.List;

/**
 * Utility functions for quick sort
 * Adopted from https://www.geeksforgeeks.org/quick-sort/?ref=leftbar-rightbar
 */
public class QuickSort extends BaseSort {

    public QuickSort(List<Person> persons) {
        super(persons);
    }

    @Override
    public BaseSort perform() {
        long start = System.currentTimeMillis();
        quickSort(persons, 0, persons.size() - 1);
        long end = System.currentTimeMillis();
        duration = end - start;
        return this;
    }

    static void swap(List<Person> list, int i, int j) {
        Person temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    static int partition(List<Person> list, int low, int high) {

        // pivot
        String pivot = list.get(high).getName();

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (list.get(j).getName().compareTo(pivot) < 0) {

                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(List<Person> list, int low, int high) {
        if (low < high) {

            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }
}
