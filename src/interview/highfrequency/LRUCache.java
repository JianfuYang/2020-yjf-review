package interview.highfrequency; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: interview.highfrequency.LRUCache
 * Author:   Jianf
 * Date:     2020/7/18 22:31
 * Description: LRU缓存机制算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈LRU缓存机制算法：自定义双向链表+哈希表实现；也可以使用直接JDK中的LinkedHashMap实现〉
 *
 * @author Jianf
 * @create 2020/7/18
 * @since 1.0.0
 */
class LRUCache {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            //如果key不存在，则创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            //添加进哈希表
            cache.put(key,newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if(size > capacity){
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else{
            //如果key存在，先通过哈希表定位，再修改value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    //添加一个节点到头节点
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //删除节点
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //移动到头节点
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    //移除尾节点
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your interview.highfrequency.LRUCache object will be instantiated and called as such:
 * interview.highfrequency.LRUCache obj = new interview.highfrequency.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */