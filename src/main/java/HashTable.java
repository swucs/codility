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

        @Override
        public String toString() {
            return "[key :" + key + ", value =" + value +"]";
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
            System.out.println("nodes[index] = " + nodes[index]);
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
        return key.hashCode() % size;
    }


}
