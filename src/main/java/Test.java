public class Test {
    public boolean solution(String[] phone_book) {
        if (phone_book.length == 1) {
            return true;
        }

        for (int i = 0; i < phone_book.length; i++) {

            String phone1 = phone_book[i];

            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) {
                    continue;
                }

                String phone2 = phone_book[j];
                if (phone2.startsWith(phone1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
