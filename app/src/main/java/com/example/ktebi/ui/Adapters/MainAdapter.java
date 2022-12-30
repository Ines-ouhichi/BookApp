package com.example.ktebi.ui.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktebi.DetailActivity;
import com.example.ktebi.R;
import com.example.ktebi.ui.DBHelpers2;
import com.example.ktebi.ui.Models.MainModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list;
    Context context;
    DBHelpers2 DB2;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override

    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.display_books,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model=list.get(position);
        holder.bookImg.setImageResource(model.getImage());
        holder.Bookname.setText(model.getName());
        holder.Bookdescription.setText(model.getDescription());
        holder.Bookrating.setText(model.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getName());
                intent.putExtra("rating",model.getRating());
                intent.putExtra("description",model.getDescription());
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DB2= new DBHelpers2(context);
                if(DB2.DeleteBook(model.getName())>0){
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView bookImg;
        TextView  Bookname,Bookdescription,Bookrating;

        public viewholder(@NonNull View itemView){
            super(itemView);
            bookImg=itemView.findViewById(R.id.imageview);
            Bookname=itemView.findViewById(R.id.BookName);
            Bookdescription=itemView.findViewById(R.id.BookDescription);
            Bookrating=itemView.findViewById(R.id.BookRating);



        }
    }
}
