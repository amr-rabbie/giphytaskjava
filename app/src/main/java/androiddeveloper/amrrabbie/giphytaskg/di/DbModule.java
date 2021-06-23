package androiddeveloper.amrrabbie.giphytaskg.di;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import androiddeveloper.amrrabbie.giphytaskg.db.GiphyDao;
import androiddeveloper.amrrabbie.giphytaskg.db.GiphyDb;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DbModule {

    @Provides
    @Singleton
    public static GiphyDb provideGiphyDb(Application application){
        return Room.databaseBuilder(application.getApplicationContext(),
                GiphyDb.class,"giphy_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static GiphyDao provideGiphyDao(GiphyDb giphyDb){
        return giphyDb.giphyDao();
    }
}
