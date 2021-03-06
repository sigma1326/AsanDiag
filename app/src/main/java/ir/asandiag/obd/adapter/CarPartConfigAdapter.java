package ir.asandiag.obd.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import ir.asandiag.obd.R;
import ir.asandiag.obd.model.CarPartConfigItem;

public class CarPartConfigAdapter extends ListAdapter<CarPartConfigItem, CarPartConfigAdapter.ViewHolder> {

    private OnCarPartConfigItemClickListener onCarPartConfigItemClickListener;

    public interface OnCarPartConfigItemClickListener {
        void onCarPartConfigItemClick(CarPartConfigItem carPartConfigItem, int pos);
    }

    public CarPartConfigAdapter(@NonNull DiffUtil.ItemCallback<CarPartConfigItem> diffCallback) {
        super(diffCallback);
    }

    public CarPartConfigAdapter(@NonNull DiffUtil.ItemCallback<CarPartConfigItem> diffCallback, OnCarPartConfigItemClickListener onCarPartConfigItemClickListener) {
        super(diffCallback);
        this.onCarPartConfigItemClickListener = onCarPartConfigItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_part_config, parent, false);
        ViewCompat.setLayoutDirection(v, ViewCompat.LAYOUT_DIRECTION_LTR);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarPartConfigItem carPartConfigItem = getItem(position);
        if (carPartConfigItem != null) {
            holder.carPartConfigItem = carPartConfigItem;
            holder.position = position;
            AppCompatTextView content = holder.itemView.findViewById(R.id.tv_item_car_part_config_title);
            content.setText(carPartConfigItem.getName());
            holder.itemView.setOnClickListener(v -> {
                if (onCarPartConfigItemClickListener != null) {
                    onCarPartConfigItemClickListener.onCarPartConfigItemClick(holder.carPartConfigItem, position);
                }
            });
            Drawable img = null;
            switch (holder.carPartConfigItem.getId()) {
                case 0:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_sensor);
                    break;
                case 1:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_fuel);
                    break;
                case 2:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_info_circle);
                    break;
                case 3:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_search_small);
                    break;
                case 4:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_param_check);
                    break;
                case 5:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_voltmeter);
                    break;
                case 6:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_reset);
                    break;
                case 7:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_info_circle);
                    break;
                case 8:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_special_ops);
                    break;
                default:
                    img = AppCompatResources.getDrawable(holder.itemView.getContext(),R.drawable.ic_info_circle);
            }
            img.setBounds(0, 0, (int) dp2px(holder.itemView.getContext(), 20), (int) dp2px(holder.itemView.getContext(), 20));
            content.setCompoundDrawables(null, null, img, null);

        }


    }

    public float dp2px(@NonNull Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CarPartConfigItem carPartConfigItem;
        private int position = 0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class ItemDiffCallBack extends DiffUtil.ItemCallback<CarPartConfigItem> {

        @Override
        public boolean areItemsTheSame(@NonNull CarPartConfigItem oldItem, @NonNull CarPartConfigItem newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CarPartConfigItem oldItem, @NonNull CarPartConfigItem newItem) {
            return false;
        }
    }

}
