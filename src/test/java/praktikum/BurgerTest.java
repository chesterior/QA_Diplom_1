package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final float PRICE_INGREDIENT = 3f;
    private static final float PRICE_BUN = 2f;
    @Mock
    Bun bunMock;
    @Mock
    private Ingredient ingredientMock;
    Burger burger;

    @Before
    public void setUp() throws Exception {
        when(bunMock.getName()).thenReturn("name");
        when(bunMock.getPrice()).thenReturn(PRICE_BUN);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("souce");
        when(ingredient1.getPrice()).thenReturn(PRICE_INGREDIENT);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("meat");
        when(ingredient2.getPrice()).thenReturn(PRICE_INGREDIENT);

        burger = new Burger();
        burger.setBuns(bunMock);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.ingredients = ingredients;
    }

    @Test
    public void setBunsBurger() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }


    @Test
    public void getPrice() {
        float expectedPrice = PRICE_BUN * 2 + PRICE_INGREDIENT * 2;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }


    @Test
    public void addIngredient() {
        int oldSize = burger.ingredients.size();
        burger.addIngredient(ingredientMock);
        assertEquals(oldSize + 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        int oldSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(oldSize - 1, burger.ingredients.size());
    }


    @Test
    public void moveIngredient() {
        int oldSize = burger.ingredients.size();
        burger.moveIngredient(0, 1);
        assertEquals(oldSize, burger.ingredients.size());
    }

    @Test
    public void getReceipt() {
        String expected = "(==== name ====)\n"
                + "= sauce souce =\n"
                + "= filling meat =\n"
                + "(==== name ====)\n"
                + "\n"
                + "Price: 10,000000\n";

        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
