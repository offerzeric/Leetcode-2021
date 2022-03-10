package laicode.test;

import java.util.Arrays;

/**
 * hashmap is kind of LinkedList
 *
 * @author ericzhang 2022/03/09 17:30
 */
public class MyHashMap <K,V> {
   public static class Node<K, V> {
      public K getKey() {
         return key;
      }

      public V getValue() {
         return value;
      }

      public void setValue(V value) {
         this.value = value;
      }

      final K key;
      V value;
      Node<K,V> next;

      public Node(K key, V value) {
         this.key = key;
         this.value = value;
      }
   }


   private Node<K,V>[] array;
   private int size;
   private float loadFactor;
   private static final int DEFAULT_CAPACITY = 16;
   private static final float DEFAULT_LOAD_FACTOR  = 0.75f;
   private static final int SCALE_FACTOR  = 2;

   public MyHashMap(int capacity, float loadFactor){
      if(capacity <= 0){
         throw new IllegalArgumentException("capacity cannot be <= 0");
      }
      this.array =   (Node<K,V>[])(new Node[capacity]);
      this.size = 0;
      this.loadFactor = loadFactor;
   }

   public MyHashMap(){
      this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
   }
   public int size(){
      return size;
   }
   public void clear(){
      Arrays.fill(array,null);
      size = 0;
   }

   // int code = key.hashCode();
   //return code >= 0?code : -code
   //int range = [-2^31, 2^31-1]
   //-Integer.MIn_Value = Integer.MIn_Value -> overFlow
   private int hash(K key){
      if(key == null){
         return 0;
      }
      return key.hashCode()&0x7fffffff; //确保non negative  reminder 可能为负数
   }

   public int getIndex(K key){
      int hash = hash(key);
      int length = array.length;
      int index = hash % length;
      return index;
   }

   public boolean equalsValue(V v1, V v2){
      if(v1 == null && v2 == null){
         return true;
      }
      if(v1 == null || v2 == null){
         return false;
      }
      return v1.equals(v2);
   }

   //o(n)
   public boolean containsValue(V value){
      if(isEmpty()){
         return false;
      }
      for (Node<K, V> kvNode : array) {
         while (kvNode != null) {
            if (equalsValue(kvNode.value,value)) {
               return true;
            }
            kvNode= kvNode.next;
         }
      }
      return false;
   }

   private boolean isEmpty() {
      return size == 0;
   }

   public boolean equalsKey(K k1, K k2){
      if(k1 == null && k2 == null){
         return true;
      }
      if(k1 == null || k2 == null){
         return false;
      }
      return k1.equals(k2);
   }

   public boolean containsKey(K key){
      if(isEmpty()){
         return false;
      }
      int index = getIndex(key);
      Node<K,V> node = array[index];
      while (node != null){
         if(equalsKey(node.key,key)){
            return true;
         }
         node = node.next;
      }
      return false;
   }

   public  V get(K key){
      int index = getIndex(key);
      Node<K,V> node = array[index];
      while (node != null){
         if(equalsKey(node.key,key)){
            return node.value;
         }
         node = node.next;
      }
      return null;
   }

   public V put(K key, V value){
      int index = getIndex(key);
      Node<K, V> node = array[index];
      Node<K, V> head = node;
      //update in linkedlist
      if(node != null){
         while (node != null){
            if(equalsKey(key,node.key)){
               V old = node.value;
               node.value = value;
               return old;
            }
            node = node.next;
         }
      }
      // insert in linkedlist head && array
      Node<K,V> newNode = new Node<>(key,value);
      newNode.next = head;
      array[index] = newNode;
      size++;
      if(needRehashing()){
         rehashing();
      }
      return null;
   }

   private void rehashing() {
       Node<K,V>[] oldArray = array;
       array = (Node<K, V>[])(new Node[array.length * SCALE_FACTOR]);
      for (Node<K, V> node : oldArray) {
         while (node != null){
            Node<K, V> next = node.next;
            int index = getIndex(node.key);
            node.next = array[index];
            array[index] = node;
            node = next;
         }
      }

   }

   private boolean needRehashing() {
      float ratio = (size + 0.0f) /array.length;
      return ratio > loadFactor;
   }

   public V remove(K key){
      int index = getIndex(key);
      Node<K,V> node = array[index];
      Node<K,V> pre = null;
      while (node != null){
         if(equalsKey(node.key,key)){
            if(pre != null){
               pre.next = node.next;
            }else{
               array[index] = node.next;
            }
            size--;
            return node.value;
         }
         pre = node;
         node = node.next;
      }
      return null;
   }
}
