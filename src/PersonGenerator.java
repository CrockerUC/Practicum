import static java.nio.file.StandardOpenOption.CREATE;

void main()
{
    String ID;
    String firstName;
    String lastName;
    String title;
    int YOB;
    String csvRec;
    boolean more;

    Scanner in = new Scanner(System.in);
    SafeInputObject sio = new SafeInputObject(in);

    ArrayList<Person> people = new ArrayList<>();
    Person person;
    do
    {
        ID = sio.getNonZeroLenString("Enter ID");
        firstName = sio.getNonZeroLenString("Enter First Name");
        lastName = sio.getNonZeroLenString("Enter Last Name");
        title = sio.getNonZeroLenString("Enter Title");
        YOB = sio.getRangedInt("\nEnter Year of Birth", 1940, 2010);

        person = new Person (ID, firstName, lastName, title, YOB);
        people.add(person);

        more = sio.getYNConfirm("Would you like to enter another person?");
    } while (more);

    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

    try
    {
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (Person p : people)
        {
            csvRec = p.toCSV();
            writer.write(csvRec, 0, csvRec.length());
            writer.newLine();
        }

        writer.close();
        System.out.println("\nData file written!");
        System.out.println("File: " + file.toAbsolutePath());
    }
    catch (IOException e)
    {
        System.out.println("Error writing the file.");
    }
    in.close();
}
