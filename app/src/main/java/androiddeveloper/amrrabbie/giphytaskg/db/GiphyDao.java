package androiddeveloper.amrrabbie.giphytaskg.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GiphyDao {

    @Insert
    public void insertGiphy(Giphy giphy);

    @Query("delete from giphy_table where id=:mid")
    public void deleteGiphy(int mid);

    @Query("select * from giphy_table")
    public LiveData<List<Giphy>> getGiphys();
}
