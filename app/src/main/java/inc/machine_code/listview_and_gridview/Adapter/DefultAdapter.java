package inc.machine_code.listview_and_gridview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import inc.machine_code.listview_and_gridview.Defult_Item.Defult_Class;
import inc.machine_code.listview_and_gridview.R;

public class DefultAdapter extends RecyclerView.Adapter<DefultAdapter.ViewHolder> {
    private InterfaceCallback callback;
    public ArrayList<Defult_Class> defult_classArrayList;
    Defult_Class defult_classObj;

    public DefultAdapter(InterfaceCallback callback, ArrayList<Defult_Class> defult_classArrayList) {
        this.callback = callback;
        this.defult_classArrayList = defult_classArrayList;
    }

    public interface InterfaceCallback {
        void inClickEvent(Defult_Class satellite);

    }

    public class EmptyHolder extends Defult_View_Holder {

        public EmptyHolder(View view) {
            super(view);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        try {
            holder.onBind(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defult_classObj = new Defult_Class();
                Defult_Class defult_class = defult_classArrayList.get(position);
                callback.inClickEvent(defult_class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return defult_classArrayList.size();
    }

    class Defult_View_Holder extends RecyclerView.ViewHolder {
        ImageView p_image;
        TextView p_name,
                p_range,
                p_type;

        public Defult_View_Holder(View view) {
            super(view);
            p_image = view.findViewById(R.id.iv_any_photo);
            p_name = view.findViewById(R.id.tv_name);
            p_range = view.findViewById(R.id.tv_range);
            p_type = view.findViewById(R.id.tv_type);
        }
    }


    public class ViewHolder extends Defult_View_Holder {
        ImageView image_photo;
        TextView p_name,
                p_range,
                p_type;

        public ViewHolder(View v) {
            super(v);
            image_photo = v.findViewById(R.id.iv_any_photo);
            p_name = v.findViewById(R.id.tv_name);
            p_range = v.findViewById(R.id.tv_range);
            p_type = v.findViewById(R.id.tv_type);
        }

        public void onBind(int position) {
            try {
                Defult_Class defult_class = defult_classArrayList.get(position);
                image_photo.setImageResource(defult_classArrayList.get(position).getImage());
                p_name.setText(String.valueOf(defult_class.getName()));
                p_range.setText(String.valueOf(defult_class.getRange()));
                p_type.setText(String.valueOf(defult_class.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
