package androiddeveloper.amrrabbie.giphytaskg.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import androiddeveloper.amrrabbie.giphytaskg.utils.Constants;
import androiddeveloper.amrrabbie.network.GiphyApiService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Provides
    @Singleton
    public static OkHttpClient provideOkhttpclient(){
        return new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public static GiphyApiService provideGiphyApiService(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(Constants.Api_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(GiphyApiService.class);
    }
}
