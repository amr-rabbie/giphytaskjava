package androiddeveloper.amrrabbie.giphytaskg.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import androiddeveloper.amrrabbie.giphytaskg.DetailsActivity;
import androiddeveloper.amrrabbie.giphytaskg.MainActivity;
import androiddeveloper.amrrabbie.giphytaskg.R;
import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.viewmodel.GiphyViewModel;

public class GiphyAdapter extends RecyclerView.Adapter<GiphyAdapter.GiphyViewHolder> implements View.OnClickListener {

    Context mContext;
    List<DataItem> list;
    GiphyViewModel viewModel;

    public GiphyAdapter(Context mContext,GiphyViewModel viewModel) {
        this.mContext = mContext;
        this.viewModel=viewModel;
    }



    public void setList(List<DataItem> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public GiphyAdapter.GiphyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gifs_list_item,parent,false);
        v.setOnClickListener(this);
        return new GiphyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull GiphyAdapter.GiphyViewHolder holder, int position) {
        DataItem item=list.get(position);

        Glide.with(mContext)
                .load(item.getImages().getOriginal().getUrl())
                .into(holder.img);

        holder.cview.setTag(position);

        holder.delete.setVisibility(View.GONE);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=item.getImages().getOriginal().getUrl();

                Giphy giphy=new Giphy(url);

                viewModel.insertGiphy(giphy);
                notifyDataSetChanged();
                Toast.makeText(mContext, "Gif added to local db", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        int pos=(int)v.getTag();
        DataItem item=list.get(pos);
        Intent intent=new Intent(mContext, DetailsActivity.class);
        intent.putExtra("giphy", (Serializable) item);
        intent.putExtra("type","online");
        mContext.startActivity(intent);
    }

    public class GiphyViewHolder extends RecyclerView.ViewHolder {
        CardView cview;
        ImageView img;
        ImageButton add,delete;
        public GiphyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View v) {
            super(v);
            cview=v.findViewById(R.id.cview);
            img=v.findViewById(R.id.img);
            add=v.findViewById(R.id.ibtnadd);
            delete=v.findViewById(R.id.ibtndelete);
        }
    }
}
