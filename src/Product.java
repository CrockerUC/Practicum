import java.util.Objects;

public class Product
{
    private String IDNum;
    private String name;
    private String description;
    private double cost;

    static private int IDSeed = 1;

    /**
     * Gets the current ID seed used to generate product IDs.
     *
     * @return the current ID seed
     */
    public static int getIDSeed()
    {
        return IDSeed;
    }

    /**
     * Sets the ID seed used to generate product IDs.
     *
     * @param IDSeed the new ID seed
     */
    public static void setIDSeed(int IDSeed)
    {
        Product.IDSeed = IDSeed;
    }

    /**
     * Constructs a Product using a supplied ID.
     *
     * @param IDNum the product ID
     * @param name the product name
     * @param description the product description
     * @param cost the product cost
     */
    public Product(String IDNum, String name, String description, double cost)
    {
        this.IDNum = IDNum;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    /**
     * Constructs a Product with a generated ID.
     *
     * @param name the product name
     * @param description the product description
     * @param cost the product cost
     */
    public Product(String name, String description, double cost)
    {
        this.IDNum = genIDNum();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public String getIDNum()
    {
        return IDNum;
    }

    /**
     * Sets the product ID.
     *
     * @param IDNum the new product ID
     */
    public void setIDNum(String IDNum)
    {
        this.IDNum = IDNum;
    }

    /**
     * Generates a four-digit product ID using the current ID seed.
     *
     * @return a four-digit product ID
     */
    private String genIDNum()
    {
        return String.format("%04d", IDSeed++);
    }

    /**
     * Gets the product name.
     *
     * @return the product name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name the new product name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the product description.
     *
     * @return the product description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the product description.
     *
     * @param description the new product description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets the product cost.
     *
     * @return the product cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * Sets the product cost.
     *
     * @param cost the new product cost
     */
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    /**
     * Returns a string representation of the Product.
     *
     * @return the Product as a string
     */
    @Override
    public String toString()
    {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    /**
     * Compares this Product with another Product.
     *
     * @param o the object to compare
     * @return true if the Products contain the same data
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getCost(), product.getCost()) == 0 && Objects.equals(getIDNum(), product.getIDNum()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription());
    }

    /**
     * Generates a hash code for this Product.
     *
     * @return the Product hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getIDNum(), getName(), getDescription(), getCost());
    }

    /**
     * Converts the Product to CSV format.
     *
     * @return the Product as a CSV string
     */
    public String toCSV()
    {
        return IDNum + ", " + name + ", " + description + ", " + cost;
    }

    /**
     * Converts the Product to JSON format.
     *
     * @return the Product as a JSON string
     */
    public String toJSON()
    {
        return "{\"IDNum\":\"" + IDNum +
                "\", \"name\":\"" + name +
                "\", \"description\":\"" + description +
                "\", \"cost\":" + cost + "}";
    }

    /**
     * Converts the Product to XML format.
     *
     * @return the Product as an XML string
     */
    public String toXML()
    {
        return "<Product>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<name>" + name + "</name>" +
                "<description>" + description + "</description>" +
                "<cost>" + cost + "</cost>" +
                "</Product>";
    }
}