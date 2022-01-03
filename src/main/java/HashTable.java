import java.util.LinkedList;
import java.util.Optional;

public class HashTable<K, V> {
    class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    int size;
    LinkedList<Node<K, V>>[] nodes;
    public HashTable(int size) {
        this.size = size;
        nodes = new LinkedList[size];
    }

    public void put(K key, V value) {
        Node<K, V> foundNode = searchKey(key);
        if (foundNode != null) {
            foundNode.value = value;
        } else {
            int index = getIndex(key);
            if(nodes[index] == null || nodes[index].size() == 0) {
                nodes[index] = new LinkedList<>();
            }
            nodes[index].add(new Node<>(key, value));
        }
    }

    public V get(K key) {
        Node<K, V> foundNode = searchKey(key);
        if (foundNode != null) {
            return foundNode.value;
        } else {
            return null;
        }
    }


    public Node<K, V> searchKey(K key) {
        int index = getIndex(key);

        if(nodes[index] == null || nodes[index].size() == 0) {
            return null;
        } else {

            Optional<Node<K, V>> matchedNode = nodes[index].stream()
                    .filter(n -> n.key.equals(key))
                    .findFirst();

            return matchedNode.orElse(null);
        }
    }

    private int getIndex(K key) {
        System.out.println("key.hashCode() = " + key.hashCode());
        System.out.println("key.hashCode() % size = " + key.hashCode() % size);
        return key.hashCode() % size;
    }

    public static void main(String[] args) {

        HashTable<String, String> hashTable = new HashTable<>(100);

        String test = "박한나3";
        hashTable.put("test", "박한나");
        hashTable.put("test2", test);
        hashTable.put("test3", test);

        System.out.println("hashTable.get(\"test\") = " + hashTable.get("test"));
        System.out.println("hashTable.get(\"test2\") = " + hashTable.get("test2"));
        System.out.println("hashTable.get(\"test3\") = " + hashTable.get("test3"));
    }

}
