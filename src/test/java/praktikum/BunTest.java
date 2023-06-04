package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Brioche", 2.99f},
                {"Sesame", 1.99f},
                {"Whole Wheat", 2.49f}
        });
    }

    @Test
    public void getNameBun() {
        Bun bun = new Bun(name, price);
        String name = bun.getName();
        assertEquals(this.name, name);
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun(name, price);
        float price = bun.getPrice();
        assertEquals(this.price, price, 0.01f);
    }
}
