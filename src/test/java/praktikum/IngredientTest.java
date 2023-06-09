package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void getPrice() {
        float expectPrice = 5.0f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Name", expectPrice);

        float actual = ingredient.getPrice();

        assertEquals(expectPrice, actual, 0.01f);
    }

    @Test
    public void getName() {
        String expectName = "name";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectName, 5.0f);

        String actual = ingredient.getName();

        assertEquals(expectName, actual);
    }

    @Test
    public void getType() {
        IngredientType expectType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(expectType, "name", 5.0f);

        IngredientType actual = ingredient.getType();

        assertEquals(expectType, actual);
    }
}
