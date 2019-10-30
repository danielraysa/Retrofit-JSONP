package com.drp.belajarretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CustomViewHolder> {

    private List<Post> dataList;

    public PostAdapter(List<Post> dataList){

        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

    //Get a reference to the Views in our layout//
        public final View myView;

        TextView textUser, textContent;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            textUser = myView.findViewById(R.id.user);
            textContent = myView.findViewById(R.id.post_content);

        }
    }

    @Override

//Construct a RecyclerView.ViewHolder//

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override

    //Set the data//
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getTitle());
        holder.textContent.setText(dataList.get(position).getBody());

    }

    //Calculate the item count for the RecylerView//
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}