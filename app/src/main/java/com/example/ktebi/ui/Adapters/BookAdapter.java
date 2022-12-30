package com.example.ktebi.ui.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktebi.R;
import com.example.ktebi.miseActivity;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.viewholder>{
    private Context context;
    private ArrayList book_id, book_title, book_desc;


    public BookAdapter( Context context, ArrayList book_id, ArrayList book_title, ArrayList book_desc){
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_desc = book_desc;


    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book,parent,false);
        return new BookAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_desc_txt.setText(String.valueOf(book_desc.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, miseActivity.class);
                intent.putExtra("id", String.valueOf(book_id.get(position)));
                intent.putExtra("title", String.valueOf(book_title.get(position)));
                intent.putExtra("desc", String.valueOf(book_desc.get(position)));

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {


        TextView book_id_txt, book_title_txt, book_desc_txt;
        LinearLayout mainLayout;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_desc_txt = itemView.findViewById(R.id.book_desc_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);

        }
    }

}
