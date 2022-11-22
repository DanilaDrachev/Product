import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book = new Book(1, "Harry Potter", 300, "Rowlling");

        manager.add(book);

        Product[] actual = manager.findAll();
        Product[] expected = {book};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenFewProdactsFinded() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowlling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowlling");
        Book book3 = new Book(3, "Tanya Grotter", 300, "Rowlling");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductExist() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowlling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowlling");
        Book book3 = new Book(3, "Tanya Grotter", 300, "Rowlling");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
}
