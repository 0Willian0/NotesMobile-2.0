package com.example.notesmobile;

public class Notes {

    public static final String tableName = "Notes";

    public static final String idColumn = "idNote";

    public static final String titleColumn = "title";

    public static final String descriptionColumn = "description";

    public static final String createTable = "CREATE TABLE " + tableName + "("
            + idColumn + " INTEGER PRIMARY KEY AUTOINCREMENT," + titleColumn + " TEXT,"
            + descriptionColumn + " TEXT"
            +")";

    public static final String DropTable = "DROP TABLE IF EXISTS " + tableName;

    public int id;
    public String title;
    public String description;

    public Notes(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
