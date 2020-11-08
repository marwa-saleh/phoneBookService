package com.phonebookservice.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int index = 0;

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
        if (this.index > this.data.length - 1) {
            this.increaseSize();
        }

        this.data[this.index] = element;
        this.index++;
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
        this.checkIndex(index);

        if (index <= this.index) {
            if (this.index > this.data.length - 1) {
                this.increaseSize();
            }

            for (int i = this.index; i > index; i--) {
                this.data[i] = this.data[i - 1];
            }

            this.data[index] = element;
            this.index++;
        } else {
            this.add(element);
        }
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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.index; i++) {
            this.data[i] = null;
        }

        this.index = 0;
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
        if (element == null) {
            for (int i = 0; i < this.index; i++) {
                if (this.data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.index; i++) {
                if (element.equals(this.data[i])) {
                    return i;
                }
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
        if (element == null) {
            for (int i = this.index - 1; i >= 0; i--) {
                if (this.data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = this.index - 1; i >= 0; i--) {
                if (this.data[i].equals(element)) {
                    return i;
                }
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
        return this.index == 0;
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
        return this.index;
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
        if (fromIndex < 0 || toIndex > this.index) {
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

        for (int i = 0; i < this.index; i++) {
            if (i >= fromIndex && i < toIndex) {
                subList.add(this.data[i]);
            }

            if (i > toIndex) {
                break;
            }
        }
        return subList;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     */
    @Override
    public T[] toArray() {
        return this.copyArray(this.data, this.index);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     */
    @Override
    public <T> T[] toArray(final T[] array) {

        if (array.length <= this.index) {
            return (T[]) this.copyArray(this.data, this.index);
        }

        for (int i = 0; i < this.index; i++) {
            array[i] = (T) this.data[i];
        }

        array[this.index] = null;
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
     */
    @Override
    public boolean remove(final Object element) {

        if (element == null) {
            for (int i = 0; i < this.index; i++) {
                if (this.data[i] == null) {
                    this.shiftRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < index; i++) {
                if (element.equals(this.data[i])) {
                    this.shiftRemove(i);
                    return true;
                }
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
        T object = null;

        if (this.data[index] != null) {
            object = this.data[index];
            this.remove(object);
        }

        return object;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     */
    @Override
    public boolean removeAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).
     */
    @Override
    public boolean retainAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if this list contains all of the elements of the collection.
     *
     * @param collection the collection.
     * @return true if this list contains all of the elements of the collection.
     */
    @Override
    public boolean containsAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /**
     * increase the size of data[].
     */
    private void increaseSize() {
        int newSize = this.data.length * 2;
        this.data = Arrays.copyOf(this.data, newSize);
    }

    private void checkIndex(final int i) {
        if (i > this.index - 1 || i < 0) {
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
        for (int j = i; j < this.index; j++) {
            this.data[i] = this.data[i + 1];
        }
        this.index--;
    }

}
