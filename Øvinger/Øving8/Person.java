public class Person{
    private final String firstName;
    private final String lastName;
    private final int birthYear;

    public Person(String firstName, String lastName, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName(){
        return firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getLastName() {
        return lastName;
    }
}
