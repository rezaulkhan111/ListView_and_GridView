package inc.machine_code.listview_and_gridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<Product> {
    public GridViewAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;

        if(null==v){
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.grid_item,null);
        }
        Product product=getItem(position);
        ImageView imageView=v.findViewById(R.id.iv_gv_image_icon_id);
        TextView textView=v.findViewById(R.id.tv_description_id);

        imageView.setImageResource(product.getImage());
        textView.setText(product.getDescription());
        return v;
    }
}
