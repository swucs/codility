import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    @DisplayName("testHashTable")
    public void testHashTable() {

        System.out.println("test");
        HashTable<String, String> hashTable = new HashTable<>(2);

        hashTable.put("test", "박한나");
        hashTable.put("test2", "박한나2");
        hashTable.put("test2", "박한나3");


        assertThat(hashTable.get("test")).isEqualTo("박한나");
        assertThat(hashTable.get("test2")).isEqualTo("박한나3");
//        assertThat(hashTable.get("test3")).isEqualTo("박한나3");

        System.out.println("hashTable.get(\"test\") = " + hashTable.get("test"));
        System.out.println("hashTable.get(\"test2\") = " + hashTable.get("test2"));
        System.out.println("hashTable.get(\"test3\") = " + hashTable.get("test3"));

    }

}