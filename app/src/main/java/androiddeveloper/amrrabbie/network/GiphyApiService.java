package androiddeveloper.amrrabbie.network;

import androiddeveloper.amrrabbie.giphytaskg.model.GiphyResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyApiService {

    @GET("gifs/search")
    Single<GiphyResponse> getGifsFromText(
        @Query("api_key") String api_key,
        @Query("q") String q,
        @Query("limit") int limit
    );
}
