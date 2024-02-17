package edu.qc.seclass.fim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.fim.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private ArrayList<String> product_id, product_name, product_color, product_size, product_brand, product_type, product_price, product_category, product_material, product_species, product_water_resistant;
    private LayoutInflater inflater;
    private Context context;
    private OnItemClickListener mListener;
    private ProductDB productDB;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // Constructor for product list
    public ProductAdapter(Context context, ArrayList<String> product_id, ArrayList<String> product_name,
                          ArrayList<String> product_color, ArrayList<String> product_size, ArrayList<String> product_brand,
                          ArrayList<String> product_type, ArrayList<String> product_price, ArrayList<String> product_category,
                          ArrayList<String> product_material, ArrayList<String> product_species, ArrayList<String> product_water_resistant) {
        this.context = context;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_brand = product_brand;
        this.product_type = product_type;
        this.product_price = product_price;
        this.product_category = product_category;
        this.product_material = product_material;
        this.product_species = product_species;
        this.product_water_resistant = product_water_resistant;
        inflater = LayoutInflater.from(context);
        productDB = new ProductDB(context);
    }


    public void deleteProduct(int position) {
        String productId = product_id.get(position);
        productDB.deleteProduct(productId);
        product_id.remove(position);
        product_name.remove(position);
        product_color.remove(position);
        product_size.remove(position);
        product_brand.remove(position);
        product_type.remove(position);
        product_price.remove(position);
        product_category.remove(position);
        product_material.remove(position);
        product_species.remove(position);
        product_water_resistant.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_row, parent, false);
        ProductAdapter.MyViewHolder holder = new ProductAdapter.MyViewHolder(view, mListener);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.product_name.setText(product_name.get(position));
        holder.product_color.setText(product_color.get(position));
        holder.product_size.setText(product_size.get(position));
        holder.product_brand.setText(product_brand.get(position));
        holder.product_type.setText(product_type.get(position));
        holder.product_price.setText(product_price.get(position));
        holder.product_category.setText(product_category.get(holder.getAdapterPosition()));
        holder.product_material.setText(product_material.get(holder.getAdapterPosition()));
        holder.product_species.setText(product_species.get(holder.getAdapterPosition()));
        holder.product_water_resistant.setText(product_water_resistant.get(holder.getAdapterPosition()).equals("Water Resistant") ? "Water Resistant" : "Not Water Resistant");


    }

    @Override
    public int getItemCount() {
            return product_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView product_name, product_color, product_size, product_brand, product_type, product_price, product_category, product_material, product_species, product_water_resistant;
        OnItemClickListener mListener;
        ImageButton deleteButton, editButton;

        public MyViewHolder(@NonNull View itemView, ProductAdapter.OnItemClickListener listener) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name_text);
            product_color = itemView.findViewById(R.id.product_color_text);
            product_size = itemView.findViewById(R.id.product_size_text);
            product_brand = itemView.findViewById(R.id.product_brand_text);
            product_type = itemView.findViewById(R.id.product_type_text);
            product_price = itemView.findViewById(R.id.product_price_text);
            product_category = itemView.findViewById(R.id.product_cat_text);
            product_material = itemView.findViewById(R.id.product_mat_text);
            product_species = itemView.findViewById(R.id.product_species_text);
            product_water_resistant = itemView.findViewById(R.id.product_water_resistant_text);
            mListener = listener;
            itemView.setOnClickListener(this);

            deleteButton = itemView.findViewById(R.id.delete_button);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ((ProductListActivity) context).deleteProduct(position);
                }
            });

            editButton = itemView.findViewById(R.id.edit_button);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ((ProductListActivity) context).editProduct(position);
                }
            });
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
