import static java.nio.file.StandardOpenOption.CREATE;

void main() {
    Scanner pipe = new Scanner(System.in);
    ArrayList<String> records = new ArrayList<>();
    boolean more = true;
    IO.println("Product Data Entry");
    while (more) {
        String id = SafeInput.getNonZeroLenString(pipe, "Enter ID");
        String name = SafeInput.getNonZeroLenString(pipe, "Enter Product Name");
        String description = SafeInput.getNonZeroLenString(pipe, "Enter Description");
        double cost = SafeInput.getDouble(pipe, "\nEnter Cost");
        String record = String.format("%s, %s, %s, %.1f", id, name, description, cost);
        records.add(record);
        IO.println("\nRecord added:");
        IO.println(record);
        more = SafeInput.getYNConfirm(pipe, "Would you like to enter another product?");
    }
    String fileName = SafeInput.getNonZeroLenString(pipe, "Enter the name of the file to save");
    Path file = Paths.get(fileName);
    try {
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        for (String record : records) {
            writer.write(record, 0, record.length());
            writer.newLine();
        }
        writer.close();
        IO.println("\nData file written!");
        IO.println("File: " + file.toAbsolutePath());
    } catch (IOException e) {
        IO.println("Error writing the file.");
    }
    pipe.close();
}