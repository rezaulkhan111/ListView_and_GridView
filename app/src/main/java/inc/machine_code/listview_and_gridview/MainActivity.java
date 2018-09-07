package inc.machine_code.listview_and_gridview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import inc.machine_code.listview_and_gridview.Defult.DefultActivity;
import inc.machine_code.listview_and_gridview.Defult_Item.Defult_Class;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubList;
    private ViewStub stubGrid;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 1;

    static final int VIEW_MODE_LIST_VIEW = 0;
    static final int VIEW_MODE_GRID_VIEW = 1;


    List<Defult_Class> defult_classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = findViewById(R.id.stub_list);
        stubGrid = findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = findViewById(R.id.my_list_view_id);
        gridView = findViewById(R.id.my_grid_view_id);

        getProductList();


//        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
//        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LIST_VIEW);


//        switchView();

        setAdapter();


    }

    public List<Product> getProductList() {
        productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.ic_potential_of_hydrogen_foreground, "Potential Of Hydrogen"));
        productList.add(new Product(R.mipmap.ic_naitrogen_foreground, "Nitrogen"));
        productList.add(new Product(R.mipmap.ic_posporas_foreground, "Phosphorus"));
        productList.add(new Product(R.mipmap.ic_potasiam_foreground, "Potassium"));
        productList.add(new Product(R.mipmap.ic_potasiam_foreground, "Photo"));
        return productList;
    }

    private void switchView() {
        if (VIEW_MODE_GRID_VIEW == currentViewMode) {
            stubList.setVisibility(View.GONE);

            stubGrid.setVisibility(View.VISIBLE);
        } else {
            stubList.setVisibility(View.VISIBLE);

            stubGrid.setVisibility(View.GONE);
        }
        setAdapter();
    }

    private void setAdapter() {

        if (VIEW_MODE_GRID_VIEW == currentViewMode) {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
            gridView.setOnItemClickListener(onItemClick);

        } else {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
            listView.setOnItemClickListener(onItemClick);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if (VIEW_MODE_LIST_VIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRID_VIEW;
                } else {
                    currentViewMode = VIEW_MODE_LIST_VIEW;
                }
                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;
    }

    public List<Defult_Class> Number1List() {
        defult_classList = new ArrayList<>();
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.mipmap.ic_potasiam_foreground));
        return defult_classList;
    }

    public List<Defult_Class> Number2List() {
        List<Defult_Class> defult_classList = new ArrayList<>();
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        return defult_classList;
    }

    public List<Defult_Class> Number3List() {
        List<Defult_Class> defult_classList = new ArrayList<>();
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        defult_classList.add(new Defult_Class("aaaaa", "10>50", "IIIO", R.drawable.header_image));
        return defult_classList;
    }


    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            switch (position) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, DefultActivity.class);
                    intent.putExtra("savedUser", (Serializable) Number1List());
                    startActivity(intent);
                    break;
                case 1:
//                    intent.putExtra("savedUser", (Serializable) Number2List());
//                    startActivity(intent);
                    break;
                case 2:
//                    intent.putExtra("savedUser", (Serializable) Number3List());
//                    startActivity(intent);
                    break;
            }
        }
    };

}
