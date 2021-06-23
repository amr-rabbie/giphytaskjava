package androiddeveloper.amrrabbie.giphytaskg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import androiddeveloper.amrrabbie.giphytaskg.adapters.GiphyAdapter;
import androiddeveloper.amrrabbie.giphytaskg.adapters.GiphyOfflineAdapter;
import androiddeveloper.amrrabbie.giphytaskg.databinding.ActivityDetailsBinding;
import androiddeveloper.amrrabbie.giphytaskg.databinding.ActivityFavBinding;
import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.utils.Constants;
import androiddeveloper.amrrabbie.giphytaskg.viewmodel.GiphyViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavActivity extends AppCompatActivity {

    ActivityFavBinding binding;
    GiphyViewModel viewModel;
    GiphyOfflineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fav);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_fav);

        viewModel=new ViewModelProvider(this).get(GiphyViewModel.class);

        adapter=new GiphyOfflineAdapter(this,viewModel);

        bindGifsData();

    }

    private void bindGifsData(){



        viewModel.getAllGiphys();

        viewModel.getGifslistoffline().observe(FavActivity.this, new Observer<List<Giphy>>() {
            @Override
            public void onChanged(List<Giphy> giphyItems) {
                LinearLayoutManager llm=new LinearLayoutManager(FavActivity.this);
                binding.gifsrecycler.setLayoutManager(llm);
                binding.gifsrecycler.setAdapter(adapter);
                adapter.setList(giphyItems);
                binding.pbar.setVisibility(View.GONE);
                binding.gifsrecycler.setVisibility(View.VISIBLE);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
               /* Intent favIntent = new Intent(MainActivity.this, FavActivity.class);
                startActivity(favIntent);*/
                break;
            case R.id.main:
               Intent mainIntent = new Intent(FavActivity.this, MainActivity.class);
                startActivity(mainIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}