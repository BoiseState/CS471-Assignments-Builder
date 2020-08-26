package edu.boisestate.cs.cs471assignmentsbuilder;

import java.util.List;

public class Issue
{
    private int id;
    private String title;
    private String description;
    private boolean isOpen;
    private List<String> labels;
    private List<Comment> comments;

    @Override
    public String toString()
    {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isOpen=" + isOpen +
                ", labels=" + labels +
                ", comments=" + comments +
                '}';
    }
}
