package androiddeveloper.amrrabbie.giphytaskg.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Giphy.class},version = 1)
public abstract class GiphyDb extends RoomDatabase {
    public abstract GiphyDao giphyDao();
}
