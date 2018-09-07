package inc.machine_code.listview_and_gridview.Defult_Item;

public class Defult_Class {
    private String Name;
    private String Range;
    private String Type;
    private int image;

    public Defult_Class(String name, String range, String type, int image) {
        Name = name;
        Range = range;
        Type = type;
        this.image = image;
    }

    public Defult_Class() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
