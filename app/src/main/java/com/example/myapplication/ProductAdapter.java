package com.example.myapplication;


    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

        private List<Product> list;
        private Context context;

        public ProductAdapter(List<Product> list, Context context) {
            this.list = list;
            this.context = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgProduct;
            TextView txtName, txtQuantity;

            public ViewHolder(View itemView) {
                super(itemView);
                imgProduct = itemView.findViewById(R.id.imgProduct);
                txtName = itemView.findViewById(R.id.txtName);
                txtQuantity = itemView.findViewById(R.id.txtQuantity);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Product p = list.get(position);

            holder.txtName.setText(p.getName());
            holder.txtQuantity.setText("Qtd: " + p.getQuantity());

            Glide.with(context)
                    .load(p.getImageUrl())
                    .into(holder.imgProduct);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
