package androiddeveloper.amrrabbie.giphytaskg.repostry;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.db.GiphyDao;
import androiddeveloper.amrrabbie.giphytaskg.model.GiphyResponse;
import androiddeveloper.amrrabbie.network.GiphyApiService;
import io.reactivex.rxjava3.core.Single;

public class GiphyRepostry {

    private GiphyApiService giphyApiService;
    private GiphyDao giphyDao;

    @Inject
    public GiphyRepostry(GiphyApiService giphyApiService,GiphyDao giphyDao) {
        this.giphyApiService = giphyApiService;
        this.giphyDao=giphyDao;
    }

    public Single<GiphyResponse> getGifsFromText(String api_key,String text,int limit){
        return giphyApiService.getGifsFromText(api_key,text,limit);
    }

    public void insertGiphy(Giphy giphy){
        giphyDao.insertGiphy(giphy);
    }

    public void deleteGiphy(int id){
        giphyDao.deleteGiphy(id);
    }

    public LiveData<List<Giphy>> getAllGiphys(){
        return giphyDao.getGiphys();
    }
}
