package BSIL;

public class People
{

    private String name;
    private int age;
    private String polAff;

    public People (String name, int age, String polAff)
    {

        this.name = name;
        this.age = age;
        this.polAff = polAff;
    }

    public String toString()
    {
        return name + " - " + age + " - " + polAff;
    }

}
