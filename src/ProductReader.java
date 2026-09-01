import javax.swing.*;

import static java.nio.file.StandardOpenOption.CREATE;

void main() {
    Scanner pipe = new Scanner(System.in);
    JFileChooser chooser = new JFileChooser();
    File workingDirectory = new File(System.getProperty("user.dir"));
    chooser.setCurrentDirectory(workingDirectory);
    IO.println("Select a Product data file.");
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    {
        File selectedFile = chooser.getSelectedFile();
        Path file = selectedFile.toPath();
        try
        {
            InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            IO.println();
            System.out.printf("%-10s %-15s %-30s %10s%n", "ID#", "Name", "Description", "Cost");
            IO.println("================================================================");
            String rec;
            while ((rec = reader.readLine()) != null)
            {
                String[] fields = rec.split(",");
                if (fields.length == 4)
                {
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String description = fields[2].trim();
                    double cost = Double.parseDouble(fields[3].trim());
                    System.out.printf("%-10s %-15s %-30s %10.1f%n", id, name, description, cost);
                }
                else
                {
                    IO.println("Found a record that may be corrupt:");
                    IO.println(rec);
                }
            }
            reader.close();
            IO.println("\nData file read!");
        }
        catch (FileNotFoundException e)
        {
            IO.println("File not found!");
        }
        catch (IOException e)
        {
            IO.println("Error reading file.");
        }
    }
    else
    {
        IO.println("No file was selected.");
        IO.println("Run the program again and select a file.");
    }
    pipe.close();
}