package example.com.recyclerviewlab;

/**
 * Created by raymour on 7/5/16.
 */
public class CustomObject2 {

    private String itemTitle;
    private String itemColor;

    public CustomObject2(String mItemTitle, String mItemColor) {

        itemTitle = mItemTitle;
        itemColor = mItemColor;

    }

    public String getItemColor() {
        return itemColor;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

}
