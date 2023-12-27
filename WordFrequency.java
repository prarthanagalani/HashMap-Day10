import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class MyMapNode {

    String key;
    int value;
    MyMapNode next;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// hash table using LL for each index
class MyHashTable {

    private List<KeyValueLinkedList> buckets;

    // num - total number of buckets
    public MyHashTable(int num) {
        this.buckets = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            buckets.add(new KeyValueLinkedList());
        }
    }

    // add key value pair to hash table
    public void put(String key) {
        int index = getIndex(key);
        buckets.get(index).add(key);
    }

    public void display() {
        System.out.println("word frequencies: ");
        for (KeyValueLinkedList list : buckets) {
            list.display();
        }
    }

    // get index for a key using hash code
    private int getIndex(String key) {
        return Math.abs(key.hashCode() % buckets.size());
    }
}

// class having linkedlist implementation
class KeyValueLinkedList {

    private MyMapNode head;

    public KeyValueLinkedList() {
        this.head = null;
    }

    // add a key value pair to linkedlist

    public void add(String key) {
        MyMapNode cur = head;

        while (cur != null) {
            if (cur.key.equals(key)) {
                // if key already exist, increament the frequency
                cur.value++;
                return;
            }
            cur = cur.next;
        }

        // if key does not exist, create new node
        MyMapNode newnode = new MyMapNode(key, 1);
        newnode.next = head;
        head = newnode;

    }

    public void display() {
        MyMapNode cur = head;

        while (cur != null) {
            System.out.println(cur.key + " : " + cur.value);
            cur = cur.next;
        }
    }

}

public class WordFrequency {

    public static void main(String[] args) {
        System.out.println("hello");

        // input
        String input = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations.";

        // tokenize input
        StringTokenizer tokens = new StringTokenizer(input);

       
        // create hashtable-uc2
        MyHashTable wordFrequencyTable = new MyHashTable(10);

        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
            wordFrequencyTable.put(word);
        }

        wordFrequencyTable.display();

    }

}
