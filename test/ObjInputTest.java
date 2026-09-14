void main() {
    SafeInputObject sio = new SafeInputObject();

    IO.println("Testing getNonZeroLenString:");
    String name = sio.getNonZeroLenString("Enter your name");
    IO.println("You entered: " + name);

    IO.println("\nTesting getInt:");
    int age = sio.getInt("Enter your age");
    IO.println("You entered: " + age);

    IO.println("\nTesting getDouble:");
    double height = sio.getDouble("Enter your height");
    IO.println("You entered: " + height);

    IO.println("\nTesting getRangedInt:");
    int number = sio.getRangedInt(
            "Enter a number between 1 and 100", 1, 100);
    IO.println("You entered: " + number);

    IO.println("\nTesting getRangedDouble:");
    double price = sio.getRangedDouble(
            "Enter a number between 1.0 and 100.0", 1.0, 100.0);
    IO.println("You entered: " + price);

    IO.println("\nTesting getYNConfirm:");
    boolean answer = sio.getYNConfirm(
            "Would you like to continue?");
    IO.println("You entered: " + answer);

    IO.println("\nTesting getRegExString:");
    String code = sio.getRegExString(
            "Enter three uppercase letters", "[A-Z]{3}");
    IO.println("You entered: " + code);

    IO.println("\nTesting prettyHeader:");
    sio.prettyHeader("SafeInputObject Test");

    IO.println("\nAll SafeInputObject methods tested.");
}
