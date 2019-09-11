package cn.itcast.util;

import java.util.LinkedList;

public class FileLinkedList<E> {
    private final LinkedList<E> linkedList = new LinkedList<E>();

    /**
     * 添加元素的方法
     *
     * @author z
     */
    public void add(E obj) {
        linkedList.addFirst(obj);
    }

    /**
     * 获取元素的方法
     *
     * @author z
     */
    public E get() {
        return linkedList.removeLast();
    }

    /**
     * 判断队列是否为空
     */
    public boolean isNull() {
        return linkedList.isEmpty();
    }

}
