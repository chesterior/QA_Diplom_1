package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testValueOf() {
        IngredientType sauceType = IngredientType.valueOf("SAUCE");
        assertEquals(IngredientType.SAUCE, sauceType);

        IngredientType fillingType = IngredientType.valueOf("FILLING");
        assertEquals(IngredientType.FILLING, fillingType);
    }
}
