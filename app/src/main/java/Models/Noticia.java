package Models;

import java.util.Date;

public class Noticia {
    public int id;
    public String image;
    public String title;
    public String detail;
    public Date start;
    public Date end;
    public int active;
    public int category_id;
    public String name;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public int getActive() {
        return active;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }
}
