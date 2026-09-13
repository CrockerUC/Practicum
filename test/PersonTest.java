import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{
    private Person person;

    @BeforeEach
    void setUp()
    {
        person = new Person("000001", "John", "Doe", "Mr.", 2000);
    }

    @Test
    void setIDSeed()
    {
        Person.setIDSeed(100);

        Person testPerson = new Person(
                "Jane",
                "Smith",
                "Ms.",
                1995);

        assertEquals("0100", testPerson.getIDNum());

        Person.setIDSeed(1);
    }

    @Test
    void setIDNum()
    {
        person.setIDNum("000999");

        assertEquals("000999", person.getIDNum());
    }

    @Test
    void setFirstName()
    {
        person.setFirstName("Jane");

        assertEquals("Jane", person.getFirstName());
    }

    @Test
    void setLastName()
    {
        person.setLastName("Smith");

        assertEquals("Smith", person.getLastName());
    }

    @Test
    void setTitle()
    {
        person.setTitle("Dr.");

        assertEquals("Dr.", person.getTitle());
    }

    @Test
    void setYOB()
    {
        person.setYOB(1990);

        assertEquals(1990, person.getYOB());
    }

    @Test
    void getAge()
    {
        assertEquals("26", person.getAge());
    }

    @Test
    void testGetAge()
    {
        assertEquals("30", person.getAge(2030));
    }

    @Test
    void fullName()
    {
        assertEquals(
                "John Doe",
                person.fullName());
    }

    @Test
    void formalName()
    {
        assertEquals(
                "Mr. John Doe",
                person.formalName());
    }

    @Test
    void testToString()
    {
        assertEquals(
                "Person{IDNum='000001', firstName='John', lastName='Doe', title='Mr.', YOB=2000}",
                person.toString());
    }

    @Test
    void toCSV()
    {
        assertEquals(
                "000001, John, Doe, Mr., 2000",
                person.toCSV());
    }

    @Test
    void toJSON()
    {
        assertEquals(
                "{\"IDNum\":\"000001\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"title\":\"Mr.\", \"YOB\":2000}",
                person.toJSON());
    }

    @Test
    void toXML()
    {
        assertEquals(
                "<Person><IDNum>000001</IDNum><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>2000</YOB></Person>",
                person.toXML());
    }

    @Test
    void equals()
    {
        Person samePerson =
                new Person("000001", "John", "Doe", "Mr.", 2000);

        Person differentPerson =
                new Person("000002", "Jane", "Smith", "Ms.", 1995);

        assertEquals(person, samePerson);
        assertNotEquals(person, differentPerson);
    }
}