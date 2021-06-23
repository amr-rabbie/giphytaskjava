package androiddeveloper.amrrabbie.giphytaskg.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "giphy_table")
public class Giphy implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    @ColumnInfo(name = "_title")
    @Ignore
    private String title;

    public Giphy(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
