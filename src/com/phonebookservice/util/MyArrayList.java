package com.phonebookservice.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int currentIndex = 0;

    /**
     * Initialization of array.
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialization of array.
     *
     * @param size the size.
     */
    public MyArrayList(final int size) {
        super();
        if (size < 0) {
            throw new IllegalArgumentException("Invalid size: " + size
                    + ". The size should be positive number");
        }
        this.data = (T[]) new Object[size];
    }

    /**
     * Appends the element to the end of this list.
     *
     * @param element the element.
     * @return true if added else false.
     */
    @Override
    public boolean add(final T element) {
        if (this.currentIndex > this.data.length - 1) {
            this.increaseSize();
        }

        this.data[this.currentIndex++] = element;
        return true;
    }

    /**
     * Inserts the element at the specified position in this list.
     *
     * @param index   the index.
     * @param element the element.
     */
    @Override
    public void add(final int index, final T element) {
        this.checkIndexToAdd(index);
        if (this.currentIndex > this.data.length - 1) {
            this.increaseSize();
        }

        for (int i = this.currentIndex; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = element;
        this.currentIndex++;
    }

    /**
     * Appends all of the elements in the collection to the end of this list, in
     * the order that they are returned by the collection's iterator .
     *
     * @param collection the collection.
     * @return true if added else false.
     */
    @Override
    public boolean addAll(final Collection<? extends T> collection) {
        this.checkCollectionNotNull(collection);

        for (T value : collection) {
            this.add(value);
        }

        return collection.size() != 0;
    }

    /**
     * Inserts all of the elements in the collection into this list at the
     * specified position.
     *
     * @param index      the index.
     * @param collection the collection.
     * @return true if added else false.
     */
    @Override
    public boolean addAll(final int index,
            final Collection<? extends T> collection) {
        this.checkCollectionNotNull(collection);
        int startIndex = index;

        for (T value : collection) {
            this.add(startIndex, value);
            startIndex++;
        }

        return collection.size() != 0;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.currentIndex; i++) {
            this.data[i] = null;
        }

        this.currentIndex = 0;
    }

    /**
     * Checks if this list contains the specified element.
     *
     * @param element the element.
     * @return true if this list contains the specified element.
     */
    @Override
    public boolean contains(final Object element) {
        return this.lastIndexOf(element) != -1;
    }

    /**
     * Get the element at the specified position in this list..
     *
     * @param index the index.
     * @return the element at the specified position in this list.
     */
    @Override
    public T get(final int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param element the element
     * @return the index
     */
    @Override
    public int indexOf(final Object element) {
        for (int i = 0; i < this.currentIndex; i++) {
            if (this.checkIfEqual(element, i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @param element the element.
     * @return the index of the last occurrence of the specified element in this
     *         list, or -1 if this list does not contain the element.
     */
    @Override
    public int lastIndexOf(final Object element) {
        for (int i = this.currentIndex - 1; i >= 0; i--) {
            if (this.checkIfEqual(element, i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Checks if list empty.
     *
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return this.currentIndex == 0;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   the index.
     * @param element the element.
     * @return the element previously at the specified position.
     */
    @Override
    public T set(final int index, final T element) {
        this.checkIndex(index);
        final T prevElment = get(index);
        this.data[index] = element;
        return prevElment;
    }

    /**
     * Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return this.currentIndex;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param fromIndex the from index.
     * @param toIndex   the to index.
     * @return list of specified range within this list.
     */
    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || toIndex > this.currentIndex) {
            throw new IndexOutOfBoundsException();
        }

        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex: " + fromIndex + " > toIndex: " + toIndex);
        }

        if (fromIndex == toIndex) {
            return new MyArrayList<T>();
        }

        final List<T> subList = new MyArrayList<T>();

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(this.data[i]);
        }
        return subList;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     */
    @Override
    public T[] toArray() {
        return this.copyArray(this.data, this.currentIndex);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     *
     * @param array the array.
     * @return an array containing the elements of the list
     */
    @Override
    public <T> T[] toArray(final T[] array) {

        if (array.length < this.currentIndex) {
            return (T[]) this.copyArray(this.data, this.currentIndex);
        } else if (array.length > this.currentIndex) {
            array[this.currentIndex] = null;
        }

        for (int i = 0; i < this.currentIndex; i++) {
            array[i] = (T) this.data[i];
        }

        return array;
    }

    /**
     * @return an iterator over the elements in this list in proper sequence.
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     */
    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     */
    @Override
    public ListIterator<T> listIterator(final int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present (optional operation).
     *
     * @param element the object.
     */
    @Override
    public boolean remove(final Object element) {
        for (int i = 0; i < currentIndex; i++) {
            if (this.checkIfEqual(element, i)) {
                this.shiftRemove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Removes the element at the specified index in this list.
     *
     * @param index the index.
     */
    @Override
    public T remove(final int index) {
        this.checkIndex(index);
        T object = this.data[index];
        this.remove(object);
        return object;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param collection the collection.
     */
    @Override
    public boolean removeAll(final Collection<?> collection) {
        return this.removeCollection(collection, true);
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).
     *
     * @param collection the collection.
     */
    @Override
    public boolean retainAll(final Collection<?> collection) {
        return this.removeCollection(collection, false);
    }

    /**
     * Checks if this list contains all of the elements of the collection.
     *
     * @param collection the collection.
     * @return true if this list contains all of the elements of the collection.
     */
    @Override
    public boolean containsAll(final Collection<?> collection) {
        this.checkCollectionNotNull(collection);
        boolean changed = true;

        for (Object object : collection) {
            if (!this.contains(object)) {
                changed = false;
            }
        }

        return changed;
    }

    /**
     * increase the size of data[].
     */
    private void increaseSize() {
        int newSize = this.data.length * 2;
        this.data = Arrays.copyOf(this.data, newSize);
    }

    private void checkIndexToAdd(final int i) {
        if (i > this.currentIndex || i < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndex(final int i) {
        if (i >= this.currentIndex || i < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private T[] copyArray(final T[] data, final int index) {
        final T[] array = (T[]) new Object[index];

        for (int i = 0; i < index; i++) {
            array[i] = data[i];
        }
        return array;
    }

    private void shiftRemove(final int i) {
        for (int j = i; j < this.currentIndex; j++) {
            this.data[j] = this.data[j + 1];
        }
        this.data[--this.currentIndex] = null;
    }

    /**
     * check if element exist in data array with specified index.
     *
     * @param element the element
     * @param index   the index
     * @return true if found element in data array, else false.
     */
    private boolean checkIfEqual(final Object element, final int index) {

        return element == this.data[index]
                || this.data[index] != null && data[index].equals(element);

    }

    private void checkCollectionNotNull(final Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
    }

    private boolean removeCollection(final Collection<?> collection,
            final boolean remove) {
        this.checkCollectionNotNull(collection);
        boolean changed = false;

        for (int i = 0; i < currentIndex; i++) {
            if (collection.contains(this.data[i]) == remove) {
                this.remove(this.data[i]);
                i--;
                changed = true;
            }
        }

        return changed;
    }
}
