package com.example.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListner {

    //1.Adapter View
     RecyclerView recyclerView ;
    //2.Data Source
    List<Item> itemList;
    //3.Adapter
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        itemList = new ArrayList<>();
        //3.Adapter
        Item item1=new Item(R.drawable.fruit,"Fruit","Fresh Fruit from the Garden");
        Item item2=new Item(R.drawable.vegitables,"Vegetable","Fresh Vegetable from the Garden");
        Item item3=new Item(R.drawable.bread,"Bakery","Bread,Wheat and Beans");
        Item item4=new Item(R.drawable.beverage,"Beverage","Juice ,Tea,Coffee and Soda");
        Item item5=new Item(R.drawable.popcorn,"Snacks","Popcorn ,Donut and Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        //4.LayoutManager
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter =new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "You Choose : " + itemList.get(position).getItemName(), Toast.LENGTH_SHORT).show();
    }
}