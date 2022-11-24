package com.fsindustry.liszt.algr.stack._341;

import java.util.*;

public class FlattenNestedListIterator {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new ListNestedInteger(Arrays.asList(1, 1)));
        nestedList.add(new IntNestedInteger(2));
        nestedList.add(new ListNestedInteger(Arrays.asList(1, 1)));
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }

    public static void test2() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new ListNestedInteger(Collections.emptyList()));
        nestedList.add(new ListNestedInteger(Collections.singletonList(3)));
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class IntNestedInteger implements NestedInteger {

    private final Integer integer;

    IntNestedInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return this.integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}

class ListNestedInteger implements NestedInteger {

    private final List<NestedInteger> integers;

    ListNestedInteger(List<Integer> integers) {
        this.integers = new ArrayList<>();
        for (Integer integer : integers) {
            this.integers.add(new IntNestedInteger(integer));
        }
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.integers;
    }
}


class NestedIterator implements Iterator<Integer> {

    private final Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        flatten(nestedList);
    }


    public void flatten(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger list = nestedList.get(i);
            stack.push(list);
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }

        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            flatten(stack.pop().getList());
        }

        return false;
    }
}