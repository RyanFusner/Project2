package com.fusner.Project2;

public class Item
{
    private String title;
    private String description;
    private int priority;

    public Item(String title, String description, int priority)
    {
        this.title = title;
        this.description = description;

        if (priority > 5)
        {
            this.priority = 5;
        }
        else if (priority < 0)
        {
            this.priority = 0;
        }
        else
        {
            this.priority = priority;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void display()
    {
        System.out.println("(" + this.priority + ") " + this.title + ": " + this.description);
    }
}
