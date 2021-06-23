package androiddeveloper.amrrabbie.giphytaskg.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.model.GiphyResponse;
import androiddeveloper.amrrabbie.giphytaskg.repostry.GiphyRepostry;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GiphyViewModel extends ViewModel {

    private GiphyRepostry giphyRepostry;

    MutableLiveData<List<DataItem>> gifslist=new MutableLiveData<>();

    LiveData<List<Giphy>> gifslistoffline=null;

    @ViewModelInject
    public GiphyViewModel(GiphyRepostry giphyRepostry) {
        this.giphyRepostry = giphyRepostry;
    }

    public MutableLiveData<List<DataItem>> getGifslist() {
        return gifslist;
    }

    public LiveData<List<Giphy>> getGifslistoffline() {
        return gifslistoffline;
    }

    public void getGifsFromText(String api_key, String text, int limit){
        giphyRepostry.getGifsFromText(api_key,text,limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<GiphyResponse, List<DataItem>>() {
                    @Override
                    public List<DataItem> apply(GiphyResponse giphyResponse) throws Throwable {
                        List<DataItem> list=giphyResponse.getData();
                        return list;
                    }
                })
                .subscribe(result->gifslist.setValue(result),error-> Log.e("error",error.getMessage()));
    }

    public void insertGiphy(Giphy giphy){
        giphyRepostry.insertGiphy(giphy);
    }

    public void deleteGiphy(int id){
        giphyRepostry.deleteGiphy(id);
    }

    public void getAllGiphys(){
        gifslistoffline=giphyRepostry.getAllGiphys();
    }


}
