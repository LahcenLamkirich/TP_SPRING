package metier;

import org.junit.Assert;

public class CalculTest extends Calcule{
    public void SommeTest() {
        Calcule calcule = new Calcule();
        int a = 10;
        int b = 20;
        int expected = 30;
        int res = calcule.Somme(a, b);
        System.out.println(res);
    }
}
