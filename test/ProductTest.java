import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest
{
    private Product product;

    @BeforeEach
    void setUp()
    {
        product = new Product(
                "000001",
                "Pipeweed",
                "Long Bottom Leaf",
                600.0);
    }

    @Test
    void fullConstructor()
    {
        Product testProduct = new Product(
                "000002",
                "Lembas",
                "Elven Wayfare Bread",
                200.0);

        assertEquals(
                "000002, Lembas, Elven Wayfare Bread, 200.0",
                testProduct.toCSV());
    }

    @Test
    void overloadedConstructor()
    {
        Product.setIDSeed(100);

        Product testProduct = new Product(
                "Lembas",
                "Elven Wayfare Bread",
                200.0);

        assertEquals(
                "0100, Lembas, Elven Wayfare Bread, 200.0",
                testProduct.toCSV());

        Product.setIDSeed(1);
    }

    @Test
    void setIDSeed()
    {
        Product.setIDSeed(200);

        Product testProduct = new Product(
                "Wine",
                "Woodland Elf Wine",
                400.0);

        assertEquals(
                "0200, Wine, Woodland Elf Wine, 400.0",
                testProduct.toCSV());

        Product.setIDSeed(1);
    }

    @Test
    void setIDNum()
    {
        product.setIDNum("000999");

        assertTrue(
                product.toCSV().startsWith("000999,"));
    }

    @Test
    void setName()
    {
        product.setName("Lembas");

        assertTrue(
                product.toCSV().contains("Lembas"));
    }

    @Test
    void setDescription()
    {
        product.setDescription("Elven Wayfare Bread");

        assertTrue(
                product.toCSV().contains("Elven Wayfare Bread"));
    }

    @Test
    void setCost()
    {
        product.setCost(250.0);

        assertTrue(
                product.toCSV().endsWith("250.0"));
    }

    @Test
    void testToString()
    {
        assertEquals(
                "Product{IDNum='000001', name='Pipeweed', description='Long Bottom Leaf', cost=600.0}",
                product.toString());
    }

    @Test
    void toCSV()
    {
        assertEquals(
                "000001, Pipeweed, Long Bottom Leaf, 600.0",
                product.toCSV());
    }

    @Test
    void toJSON()
    {
        assertEquals(
                "{\"IDNum\":\"000001\", \"name\":\"Pipeweed\", \"description\":\"Long Bottom Leaf\", \"cost\":600.0}",
                product.toJSON());
    }

    @Test
    void toXML()
    {
        assertEquals(
                "<Product><IDNum>000001</IDNum><name>Pipeweed</name><description>Long Bottom Leaf</description><cost>600.0</cost></Product>",
                product.toXML());
    }

    @Test
    void equals()
    {
        Product sameProduct = new Product(
                "000001",
                "Pipeweed",
                "Long Bottom Leaf",
                600.0);

        Product differentProduct = new Product(
                "000002",
                "Lembas",
                "Elven Wayfare Bread",
                200.0);

        assertEquals(product, sameProduct);
        assertNotEquals(product, differentProduct);
    }
}