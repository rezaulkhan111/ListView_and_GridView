package inc.machine_code.listview_and_gridview.Defult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.PriorityQueue;

import inc.machine_code.listview_and_gridview.Adapter.DefultAdapter;
import inc.machine_code.listview_and_gridview.Defult_Item.Defult_Class;
import inc.machine_code.listview_and_gridview.R;

public class DefultActivity extends AppCompatActivity implements DefultAdapter.InterfaceCallback{
    DefultAdapter adapter;
    ArrayList<Defult_Class> defult_classArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defult);


        mRecyclerView = findViewById(R.id.rv_defult_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();

        ArrayList<Defult_Class> _defult_classes_Seri_able = (ArrayList<Defult_Class>) intent.getSerializableExtra("savedUser");
       defult_classArrayList= _defult_classes_Seri_able;

       adapter=new DefultAdapter( this,defult_classArrayList);
       mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void inClickEvent(Defult_Class satellite) {

    }
}
