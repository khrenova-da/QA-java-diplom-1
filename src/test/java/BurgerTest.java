import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Bun bun1 = new Bun("Булочка", 235);

        Burger burger = new Burger();
        burger.setBuns(bun1);

        Assert.assertEquals(bun1, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Начинка", 123);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);

        boolean isBurgerContainsIngredient = burger.ingredients.contains(ingredient1);

        Assert.assertTrue(isBurgerContainsIngredient);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Начинка1", 1);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        boolean isBurgerContainsIngredient = burger.ingredients.contains(ingredient1);

        Assert.assertFalse(isBurgerContainsIngredient);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Начинка1", 1);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Начинка2", 2);

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        int index = 0;
        int newIndex = 1;
        burger.moveIngredient(index, newIndex);

        int actual = burger.ingredients.indexOf(ingredient1);

        Assert.assertEquals(newIndex, actual);
    }

    @Test
    public void getPriceTest() {
        float bunPrice = 20;
        float ingredientPrice = 30;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expected = bunPrice * 2 + ingredientPrice;
        float actual = burger.getPrice();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        String bunName = "Булка с кунжутом";
        float bunPrice = 20;
        String ingredientName = "Мясная котлета";
        float ingredientPrice = 30;
        float fullPrice = bunPrice * 2 + ingredientPrice;
        IngredientType ingredientType = IngredientType.FILLING;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName, ingredientType.toString().toLowerCase(), ingredientName, bunName, fullPrice);

        Assert.assertEquals(expected, actual);
    }
}
