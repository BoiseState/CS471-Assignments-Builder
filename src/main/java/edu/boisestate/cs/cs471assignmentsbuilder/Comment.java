package edu.boisestate.cs.cs471assignmentsbuilder;

public class Comment
{
    private int id;
    private String text;

    @Override
    public String toString()
    {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
