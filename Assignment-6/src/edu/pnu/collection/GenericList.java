package edu.pnu.collection;

public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public boolean add(T data) {
        if(size >= DEFAULT_SIZE)
            return false;

        this.data[size] = data;
        size++;
        return true;
    }

    public boolean clear() {
        size = 0;
        return true;
    }

    public T find(T target) {
        T matchedObj = null;

        for (int i = 0; i < size; i++) {
            if(data[i].equals(target)) {
                matchedObj = (T) data[i];
                break;
            }
        }

        return matchedObj;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String msg = "";

        for (int i = 0; i < size; i++) {
            msg += String.format("%s\n", data[i]);
        }
        return msg;
    }
}