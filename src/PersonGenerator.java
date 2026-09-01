import static java.nio.file.StandardOpenOption.CREATE;

void main() {
    Scanner pipe = new Scanner(System.in);
    ArrayList<String> records = new ArrayList<>();
    boolean more = true;
    System.out.println("Person Data Entry");
    while (more)
    {
        String id = SafeInput.getNonZeroLenString(pipe, "Enter ID");
        String firstName = SafeInput.getNonZeroLenString(pipe, "Enter First Name");
        String lastName = SafeInput.getNonZeroLenString(pipe, "Enter Last Name");
        String title = SafeInput.getNonZeroLenString(pipe, "Enter Title");
        int yearOfBirth = SafeInput.getInt(pipe, "\nEnter Year of Birth");
        String record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
        records.add(record);
        System.out.println("\nRecord added:");
        System.out.println(record);
        more = SafeInput.getYNConfirm(pipe, "Would you like to enter another person?");
    }
    String fileName = SafeInput.getNonZeroLenString(pipe, "Enter the name of the file to save");
    Path file = Paths.get(fileName);
    try
    {
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        for (String record : records)
        {
            writer.write(record, 0, record.length());
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
    pipe.close();
}
