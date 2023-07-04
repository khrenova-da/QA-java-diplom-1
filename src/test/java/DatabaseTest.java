import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)

public class DatabaseTest {
    public int index;
    public String bunName;
    public float bunPrice;

    public DatabaseTest(int index, String bunName, float bunPrice) {
        this.index = index;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getIngredientType() {
        return Arrays.asList(new Object[][]{
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300}
        });
    }

    @Test
    public void availableBunsTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        boolean actual = buns.get(index).equals(bun);
        Assert.assertTrue(actual);
    }
}
