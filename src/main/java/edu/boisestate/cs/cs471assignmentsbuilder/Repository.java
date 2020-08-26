package edu.boisestate.cs.cs471assignmentsbuilder;

public class Repository
{
    private int id;
    private String full_name;
    private Owner owner;

    @Override
    public String toString()
    {
        return "Repository{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
