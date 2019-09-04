package Lesson_8;


public class Main {

    public static void main(String[] args) {
//       HashTable hashTable = new HashTableImpl(5);
       HashTableListImpl hashTable = new HashTableListImpl(5);
        hashTable.fill();

       hashTable.put(new Item(1,"Orange"),150);
       hashTable.put(new Item(77,"Banana"),100);
        hashTable.put(new Item(77,"Banana"),222);
        hashTable.put(new Item(60,"Lemon"),250);
        hashTable.put(new Item(21,"Potato"),65);
        hashTable.put(new Item(52,"Milk"),120);
        hashTable.display();

        System.out.println("size is:" + hashTable.size());

        System.out.println("cost potato is " + hashTable.get(new Item (21,"Potato")));

        System.out.println("remove the potato!");
        hashTable.remove(new Item(21,"Potato"));
        hashTable.display();
        System.out.println("size is:" + hashTable.size());
    }
}
