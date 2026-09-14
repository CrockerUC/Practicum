import javax.swing.JFileChooser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        System.out.println("Select a Product data file.");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            Path file = selectedFile.toPath();

            ArrayList<Product> products = new ArrayList<>();

            try
            {
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String rec;

                while ((rec = reader.readLine()) != null)
                {
                    String[] fields = rec.split(",");
                    if (fields.length == 4)
                    {
                        String ID = fields[0].trim();
                        String name = fields[1].trim();
                        String description = fields[2].trim();
                        double cost = Double.parseDouble(fields[3].trim());

                        Product product = new Product(ID, name, description, cost);
                        products.add(product);
                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt:");
                        System.out.println(rec);
                    }
                }
                reader.close();

                System.out.println();
                System.out.printf("%-10s %-15s %-30s %10s%n", "ID#", "Name", "Description", "Cost");

                System.out.println("==========================================================================");
                for (Product product : products)
                {
                    System.out.printf("%-10s %-15s %-30s %10.2f%n", product.getIDNum(), product.getName(), product.getDescription(), product.getCost());
                }
                System.out.println("\nData file read!");
            }
            catch (IOException e)
            {
                System.out.println("Error reading file.");
            }
        }
        else
        {
            System.out.println("No file was selected.");
            System.out.println("Run the program again and select a file.");
        }
    }
}