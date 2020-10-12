package id.ac.ui.cs.mobileprogramming.helloworld.lab4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.helloworld.R;
import id.ac.ui.cs.mobileprogramming.helloworld.lab4.model.Phone;

public class PhoneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Phone> mPhones = new ArrayList<>();
    Fragment mContext;


    public PhoneAdapter(Fragment context, List<Phone> phones){
        this.mPhones = phones;
        this.mContext = context;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).mName.setText(mPhones.get(position).getName());

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mPhones.get(position).getImgURL())
                .into(((ViewHolder)viewHolder).mImage);




    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_review_fragment,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public int getItemCount() {
        return mPhones.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.phoneImage);
            mName = itemView.findViewById(R.id.phoneName);
        }
    }


}
