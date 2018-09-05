package inc.machine_code.listview_and_gridview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubList;
    private ViewStub stubGrid;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LIST_VIEW = 0;
    static final int VIEW_MODE_GRID_VIEW = 1;

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


        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LIST_VIEW);
        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();
    }

    public List<Product> getProductList() {
        productList=new ArrayList<>();
        productList.add(new Product(R.mipmap.ic_icon, "Photo"));
        productList.add(new Product(R.mipmap.ic_icon, "Photo"));
        productList.add(new Product(R.mipmap.ic_icon, "Photo"));
        productList.add(new Product(R.mipmap.ic_icon, "Photo"));
        productList.add(new Product(R.mipmap.ic_icon, "Photo"));
        return productList;
    }

    private void switchView() {
        if (VIEW_MODE_LIST_VIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);

            stubGrid.setVisibility(View.GONE);
        } else {
            stubList.setVisibility(View.GONE);

            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapter();
    }

    private void setAdapter() {

        if (VIEW_MODE_LIST_VIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(getApplicationContext(), productList.get(i).getDescription() + "---" + productList.get(i).getDescription(), Toast.LENGTH_LONG).show();
        }
    };


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
}
