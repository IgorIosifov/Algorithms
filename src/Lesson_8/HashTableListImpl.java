package Lesson_8;


import java.util.ArrayList;

public class HashTableListImpl implements HashTable {

    // inner class for the entering thing
    private static class Entry {
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    //inner class for chain of entries with similar index
    private class Chain {
        private int indexChain;
        ArrayList<Entry> list;

        private Chain() {
            this.list = new ArrayList<>();
        }

        private boolean putInChain(Entry entry) {
            //checking for the similar item
            for (int i = 0; i < list.size(); i++) {
                if (entry.key.equals(list.get(i).key)) {
                    list.get(i).value = entry.value;
                    indexChain++;
                    return true;
                }
            }

            list.add(entry);
            size++;
            return true;
        }

        private boolean chainIsEmpty() {
            return list.size() == 0;
        }


        private boolean displayChain() {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "; ");
            }
            return true;
        }

        private boolean getInChain(Item item) {
            for (int i = 0; i < list.size(); i++) {
                if (item.getTitle().equals(list.get(i).key.getTitle())) {
                    return true;
                }
            }
            return false;
        }

        private Integer getCost(Item item) {
            for (int i = 0; i < list.size(); i++) {
                if (item.getTitle().equals(list.get(i).key.getTitle())) {
                    return list.get(i).value;
                }
            }
            return -1;
        }
        private boolean deleteInChain (Item item) {
            for (int i = 0; i < list.size(); i++) {
                if (item.getTitle().equals(list.get(i).key.getTitle())) {
                    list.remove(i);
                    size--;
                    return true;
                }
            }
            return false;
        }
    }

    private Chain[] data;
    private int size;
    private int maxSize;

    public HashTableListImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Chain[maxSize * 2];
    }

    private int hashFunction(Item key) {
        return key.hashCode() % data.length;
    }

    public void fill() {
        for (int i = 0; i < data.length; i++) {
            data[i] = new Chain();
        }
    }

    @Override
    public boolean put(Item item, Integer cost) {
        int index = hashFunction(item);
        while (data[index] != null) {
            data[index].putInChain(new Entry(item, cost));
            return true;
        }
        return true;
    }

    protected int getStep(Item item) {
        return 1;
    }

    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        if (!data[index].chainIsEmpty()) {
            return data[index].getCost(item);
        } else {
            return -1;
        }
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            data[index].deleteInChain(item);
            return true;
        }
        return false;
    }

    private int indexOf(Item item) {
        int index = hashFunction(item);
            while (!data[index].chainIsEmpty()) {
                if (data[index].getInChain(item)) {
                    return index;
                }
            }
                return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            if (!data[i].chainIsEmpty()) {
                System.out.println("i= " + i);
                data[i].displayChain();
                System.out.println();
            }
        }
    }
}
