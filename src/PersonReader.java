import javax.swing.*;
import static java.nio.file.StandardOpenOption.CREATE;

void main()
{
    Scanner pipe = new Scanner(System.in);

    JFileChooser chooser = new JFileChooser();

    File workingDirectory =
            new File(System.getProperty("user.dir"));

    chooser.setCurrentDirectory(workingDirectory);

    System.out.println("Select a Person data file.");

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    {
        File selectedFile = chooser.getSelectedFile();
        Path file = selectedFile.toPath();

        try
        {
            InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            System.out.println();
            System.out.printf("%-10s %-15s %-15s %-10s %6s", "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println("==========================================================");
            String rec;
            while ((rec = reader.readLine()) != null)
            {
                String[] fields = rec.split(",");

                if (fields.length == 5)
                {
                    String id = fields[0].trim();
                    String firstName = fields[1].trim();
                    String lastName = fields[2].trim();
                    String title = fields[3].trim();
                    int yearOfBirth = Integer.parseInt(fields[4].trim());
                    System.out.printf("%-10s %-15s %-15s %-10s %6d", id, firstName, lastName, title, yearOfBirth);
                }
                else
                {
                    System.out.println("Found a record that may be corrupt:");
                    System.out.println(rec);
                }
            }
            reader.close();
            System.out.println("\nData file read!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
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
    pipe.close();
}
