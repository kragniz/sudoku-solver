package eu.kragniz.sudoku.data;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

class SextupleLinkedListNode<T> {
    private T left;
    private T right;
    private T up;
    private T down;
    private T forward;
    private T backward;

    public void setLeft(T item) {
        this.left = item;
    }

    public void setRight(T item) {
        this.right = item;
    }

    public void setUp(T item) {
        this.up = item;
    }

    public void setDown(T item) {
        this.down = item;
    }

    public void setForward(T item) {
        this.forward = item;
    }

    public void setBackward(T item) {
        this.backward = item;
    }

    public T getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }

    public T getUp() {
        return this.up;
    }

    public T getDown() {
        return this.down;
    }

    public T getForward() {
        return this.forward;
    }

    public T getBackward() {
        return this.backward;
    }

}