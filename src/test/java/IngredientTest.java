import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String NAME = "Мясо бессмертных моллюсков Protostomia";
    private final float PRICE = 1337;
    private IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getIngredientType() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        });
    }

    @Test
    public void getTypeReturnsType() {
        Ingredient ingredient = new Ingredient(ingredientType, NAME, PRICE);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(ingredientType, actual);
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(ingredientType, NAME, PRICE);
        String actual = ingredient.getName();
        Assert.assertEquals(NAME, actual);
    }

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, NAME, PRICE);
        float actual = ingredient.getPrice();
        Assert.assertEquals(PRICE, actual, 0);
    }
}
