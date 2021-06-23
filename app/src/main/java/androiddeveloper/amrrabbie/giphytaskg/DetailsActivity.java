package androiddeveloper.amrrabbie.giphytaskg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androiddeveloper.amrrabbie.giphytaskg.databinding.ActivityDetailsBinding;
import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.viewmodel.GiphyViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    GiphyViewModel viewModel;
    DataItem gifs;
    String type;
    Giphy gifsoffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_details);

        viewModel=new ViewModelProvider(this).get(GiphyViewModel.class);

        Intent intent=getIntent();
        
        if(intent.hasExtra("giphy")){
            type=intent.getStringExtra("type");
            if(type.equals("online")) {
                gifs = (DataItem) intent.getSerializableExtra("giphy");
                if (gifs != null) {
                    bindGifData();
                }
            }else{
                gifsoffline = (Giphy) intent.getSerializableExtra("giphy");
                if (gifsoffline != null) {
                    bindGifDataOffline();
                }
            }
        }
    }

    private void bindGifData() {
        Picasso.get()
                .load(gifs.getImages().getOriginal().getUrl())
                .into(binding.img);
    }

    private void bindGifDataOffline() {
        Picasso.get()
                .load(gifsoffline.getUrl())
                .into(binding.img);
    }


}