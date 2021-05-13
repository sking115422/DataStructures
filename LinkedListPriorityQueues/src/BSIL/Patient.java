package BSIL;

public class Patient
{

    private String name;
    private int priority;
    private String medIssue;

    public Patient (String name, int priority, String medIssue)
    {

        this.name = name;
        this.priority = priority;
        this.medIssue = medIssue;

    }

    public int getPriority() {
        return priority;
    }

    public String toString()
    {
        return name + " : " + priority + " - " + medIssue;
    }

}
