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
import androiddeveloper.amrrabbie.giphytaskg.R;
import androiddeveloper.amrrabbie.giphytaskg.db.Giphy;
import androiddeveloper.amrrabbie.giphytaskg.model.DataItem;
import androiddeveloper.amrrabbie.giphytaskg.viewmodel.GiphyViewModel;

public class GiphyOfflineAdapter extends RecyclerView.Adapter<GiphyOfflineAdapter.GiphyViewHolder> implements View.OnClickListener {

    Context mContext;
    List<Giphy> list;
    GiphyViewModel viewModel;

    public GiphyOfflineAdapter(Context mContext,GiphyViewModel viewModel) {
        this.mContext = mContext;
        this.viewModel=viewModel;
    }



    public void setList(List<Giphy> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public GiphyOfflineAdapter.GiphyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gifs_list_item,parent,false);
        v.setOnClickListener(this);
        return new GiphyOfflineAdapter.GiphyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull GiphyOfflineAdapter.GiphyViewHolder holder, int position) {
        Giphy item=list.get(position);

        Glide.with(mContext)
                .load(item.getUrl())
                .into(holder.img);

        holder.cview.setTag(position);

        holder.add.setVisibility(View.GONE);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=item.getUrl();

                Giphy giphy=new Giphy(url);

                viewModel.deleteGiphy(giphy.getId());
                notifyDataSetChanged();
                Toast.makeText(mContext, "Gif deleted from local db", Toast.LENGTH_SHORT).show();

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
        Giphy item=list.get(pos);
        Intent intent=new Intent(mContext, DetailsActivity.class);
        intent.putExtra("giphy", (Serializable) item);
        intent.putExtra("type","offline");
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
