package com.example.notesmobile;

public class Notes {

    public static final String tableName = "Notes";

    public static final String idColumn = "idNote";

    public static final String fatherColumn = "father";

    public static final String titleColumn = "title";

    public static final String descriptionColumn = "description";

    public static final String createTable = "CREATE TABLE " + tableName + "("
            + idColumn + " INTEGER PRIMARY KEY AUTOINCREMENT," +fatherColumn + " INTEGER,"+
              titleColumn + " TEXT,"
            + descriptionColumn + " TEXT,"+
            "FOREIGN KEY ("+fatherColumn+") REFERENCES "+tableName+"("+idColumn+") ON DELETE CASCADE"
            +")";

    public static final String DropTable = "DROP TABLE " + tableName;

    public int id;

    public int father;
    public String title;
    public String description;

    public Notes(int id, int father, String title, String description)
    {
        this.id = id;
        this.father = father;
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

    public int getFather(){return father;}

    public void setFather(int father){this.father = father;}

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
