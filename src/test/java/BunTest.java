import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private static final String NAME = "Флюоресцентная булка R2-D3";
    private static final float PRICE = 988;

    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun(NAME, PRICE);
        String actual = bun.getName();
        Assert.assertEquals(NAME, actual);
    }

    @Test
    public void getPriceReturnsPrice() {
        Bun bun = new Bun(NAME, PRICE);
        float actual = bun.getPrice();
        Assert.assertEquals(PRICE, actual, 0);
    }
}
