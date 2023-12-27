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
            System.err.println(cur.key + " : " + cur.value);
            cur = cur.next;
        }
    }

}

public class WordFrequency {

    public static void main(String[] args) {
        System.out.println("hello");

        // input
        String input = "To be or not to be";

        // tokenize input
        StringTokenizer tokens = new StringTokenizer(input);

        // creating a linkedlist of key value pair
        KeyValueLinkedList wordFrequencyList = new KeyValueLinkedList();

        // counting frequency
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
            wordFrequencyList.add(word);
        }

        // display word frequencies
        System.err.println("word Frequencies: ");
        wordFrequencyList.display();

    }

}
