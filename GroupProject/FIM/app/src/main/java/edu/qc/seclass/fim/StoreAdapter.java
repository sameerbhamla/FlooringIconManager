package edu.qc.seclass.fim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.fim.R;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private ArrayList<String> store_id, store_name, store_location;
    private LayoutInflater inflater;
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public StoreAdapter(Context context, ArrayList<String> store_id, ArrayList<String> store_name, ArrayList<String> store_location) {
        this.context = context;
        this.store_id = store_id;
        this.store_name = store_name;
        this.store_location = store_location;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.store_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.store_name.setText(store_name.get(position));
        holder.store_location.setText(store_location.get(position));
    }

    @Override
    public int getItemCount() {
        return store_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView store_name, store_location;
        OnItemClickListener mListener;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            store_name = itemView.findViewById(R.id.store_name_text);
            store_location = itemView.findViewById(R.id.store_location_text);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                mListener.onItemClick(v, position);
            }
        }
    }
}
