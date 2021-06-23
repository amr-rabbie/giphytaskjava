package androiddeveloper.amrrabbie.giphytaskg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import androiddeveloper.amrrabbie.giphytaskg.adapters.GiphyAdapter;
import androiddeveloper.amrrabbie.giphytaskg.databinding.ActivityMainBinding;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.utils.Constants;
import androiddeveloper.amrrabbie.giphytaskg.viewmodel.GiphyViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    GiphyViewModel viewModel;
    GiphyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel=new ViewModelProvider(this).get(GiphyViewModel.class);

        adapter=new GiphyAdapter(this,viewModel);

        binding.btnsearch.setOnClickListener(this);


    }

    private void bindGifsData(){
        String text=binding.txttext.getText().toString();
        int limit=25;

        binding.pbar.setVisibility(View.VISIBLE);

        viewModel.getGifsFromText(Constants.Api_Key,text,limit);

        viewModel.getGifslist().observe(MainActivity.this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2);
                binding.gifsrecycler.setLayoutManager(glm);
                binding.gifsrecycler.setAdapter(adapter);
                adapter.setList(dataItems);
                binding.pbar.setVisibility(View.GONE);
                binding.gifsrecycler.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        bindGifsData();
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
                Intent favIntent = new Intent(MainActivity.this, FavActivity.class);
                startActivity(favIntent);
                break;
            case R.id.main:
               /* Intent mainIntent = new Intent(FavActivity.this, MainActivity.class);
                startActivity(mainIntent);*/
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}