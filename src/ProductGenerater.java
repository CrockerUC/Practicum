import static java.nio.file.StandardOpenOption.CREATE;

void main()
{
    String ID;
    String name;
    String description;
    double cost;
    String csvRec;
    boolean more;

    SafeInputObject sio = new SafeInputObject();

    ArrayList<Product> products = new ArrayList<>();

    Product product;

    do
    {
        ID = sio.getNonZeroLenString("Enter ID");
        name = sio.getNonZeroLenString("Enter Product Name");
        description = sio.getNonZeroLenString("Enter Product Description");
        cost = sio.getDouble("\nEnter Product Cost");

        product = new Product(ID, name, description, cost);

        products.add(product);

        more = sio.getYNConfirm("Would you like to enter another product?");

    } while (more);

    File workingDirectory = new File(System.getProperty("user.dir"));

    Path file = Paths.get(workingDirectory.getPath() + "\\src\\productData.txt");

    try
    {
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (Product p : products)
        {
            csvRec = p.toCSV();

            writer.write(csvRec, 0, csvRec.length());
            writer.newLine();
        }

        writer.close();

        IO.println("\nData file written!");
        IO.println("File: " + file.toAbsolutePath());
    }
    catch (IOException e)
    {
        IO.println("Error writing the file.");
    }
}