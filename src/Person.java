import java.util.Objects;

public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDSeed = 1;

    /**
     * Retrieves the current value of the IDSeed, which serves as a static seed for generating unique identifiers.
     *
     * @return The current value of the static IDSeed.
     */
    public static int getIDSeed() { return IDSeed; }

    /**
     * Updates the static seed value used for generating unique identifiers for instances of the {@code Person} class.
     *
     * @param IDSeed The new static seed value to be set for generating unique identifiers.
     */
    public static void setIDSeed(int IDSeed) { Person.IDSeed = IDSeed; }

    /**
     * Constructs a new Person object with the given ID number, first name, last name, title, and year of birth.
     *
     * @param IDNum     The unique identifier for the person.
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param title     The title of the person (e.g., Mr., Ms., Dr.).
     * @param YOB       The year of birth of the person.
     */
    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Constructs a new Person object with a generated ID number and given first name, last name, title, and year of birth.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param title     The title of the person (e.g., Mr., Ms., Dr.).
     * @param YOB       The year of birth of the person.
     */
    public Person(String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Retrieves the unique identifier associated with the person.
     *
     * @return The ID number of the person.
     */
    public String getIDNum() { return IDNum; }

    /**
     * Generates a unique identifier number for a person instance by incrementing the
     * static seed value {@code IDSeed} and formatting it as a zero-padded, four-digit string.
     *
     * @return A zero-padded, four-digit string representing the newly generated unique identifier.
     */
    private String genIDNum()
    {
        return String.format("%04d", IDSeed++);
    }

    /**
     * Updates the unique identifier for the person.
     *
     * @param IDNum The new ID number to be assigned to the person.
     */
    public void setIDNum(String IDNum) { this.IDNum = IDNum; }

    /**
     * Retrieves the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() { return firstName; }

    /**
     * Updates the first name of the person.
     *
     * @param firstName The new first name to be set for the person.
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Retrieves the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() { return lastName; }

    /**
     * Updates the last name of the person.
     *
     * @param lastName The new last name to be set for the person.
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Retrieves the title of the person.
     *
     * @return The title of the person (e.g., Mr., Ms., Dr.).
     */
    public String getTitle() { return title; }

    /**
     * Updates the title of the person.
     *
     * @param title The new title to be set for the person (e.g., Mr., Ms., Dr.).
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Retrieves the year of birth of the person.
     *
     * @return The year of birth of the person.
     */
    public int getYOB() { return YOB; }

    /**
     * Updates the year of birth (YOB) of the person.
     *
     * @param YOB The new year of birth to be set for the person.
     */
    public void setYOB(int YOB) { this.YOB = YOB; }

    /**
     * Calculates the approximate age of the person based on their year of birth (YOB).
     *
     * @return A string representation of the person's age, computed as the difference
     *         between the stored year of birth (YOB) and the year 2026.
     */
    public String getAge() { return String.valueOf(2026-YOB); }

    /**
     * Calculates the approximate age of the person based on the specified year.
     * The age is determined by subtracting the person's year of birth (YOB) from the given year.
     *
     * @param year The reference year for calculating the age.
     * @return A string representation of the person's age calculated as the difference
     *         between the given year and the stored year of birth (YOB).
     */
    public String getAge(int year) { return String.valueOf(year - YOB); }
    /**
     * Combines the first name and the last name of the person into a full name.
     *
     * @return The full name of the person, consisting of the first name followed by a space and the last name.
     */
    public String fullName() { return firstName + " " + lastName; }

    /**
     * Constructs the formal name of the person by combining their title and full name.
     *
     * @return The formal name of the person, consisting of their title followed by a space and their full name.
     */
    public String formalName() { return title + " " + fullName(); }

    /**
     * Returns a string representation of the Person object, including the values
     * of its fields (IDNum, firstName, lastName, title, and YOB).
     *
     * @return A string containing the field values of the Person object in the
     *         format: "Person{IDNum='value', firstName='value', lastName='value',
     *         title='value', YOB=value}".
     */
    @Override
    public String toString()
    {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getYOB() == person.getYOB() && Objects.equals(getIDNum(), person.getIDNum()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getTitle(), person.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDNum(), getFirstName(), getLastName(), getTitle(), getYOB());
    }

    /**
     * Converts the Person object's data fields into a single string formatted as CSV (Comma-Separated Values).
     * The string includes the fields: IDNum, firstName, lastName, title, and YOB, separated by commas.
     *
     * @return A CSV-formatted string containing the person's ID number, first name, last name, title,
     *         and year of birth, in that specific order.
     */
    public String toCSV() { return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB; }

    /**
     * Converts the Person object's data fields into a JSON-formatted string.
     * The JSON string includes the fields: IDNum, firstName, lastName, title, and YOB.
     *
     * @return A JSON-formatted string containing the person's ID number, first name, last name,
     *         title, and year of birth, in key-value pairs.
     */
    public String toJSON() { return "{\"IDNum\":\"" + IDNum + "\", \"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName + "\", \"title\":\"" + title + "\", \"YOB\":" + YOB + "}"; }

    /**
     * Converts the Person object's data fields into an XML-formatted string.
     * The XML string includes the fields: IDNum, firstName, lastName, title, and YOB,
     * encapsulated within corresponding XML elements.
     *
     * @return An XML-formatted string representing the person's ID number, first name,
     *         last name, title, and year of birth, in a structured format.
     */
    public String toXML() { return "<Person><IDNum>" + IDNum + "</IDNum><firstName>" + firstName + "</firstName><lastName>" + lastName + "</lastName><title>" + title + "</title><YOB>" + YOB + "</YOB></Person>"; }
}
