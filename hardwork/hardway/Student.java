public class Student
{
    private String name;
    public Student(String name)
    {
        this.name = name;
    }
    public void PrintName()
    {
        System.out.printf("%s", this.name);
    }
}