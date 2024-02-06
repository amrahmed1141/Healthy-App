package com.example.healthyapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.healthyapp.Adapter.BestDealAdapter;
import com.example.healthyapp.Adapter.CategoryAdapter;
import com.example.healthyapp.Domain.BestDealDomain;
import com.example.healthyapp.Domain.CategoryDomain;
import com.example.healthyapp.R;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView.Adapter catAdapter , bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initRecyclerviewCat();
        initRecyclerViewBestDeal();
        // Get a reference to the Spinner
        Spinner locationSpinner = findViewById(R.id.spinner);

        // Define an array of locations (replace this with your actual data)
        String[] locations = {"Cairo,Egypt","Giza,Egypt"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        locationSpinner.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetables"));
        items.add(new CategoryDomain("cat2","Fruits"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat = findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);
    }
      private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal = findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
      }
    public ArrayList<BestDealDomain> getData(){
        ArrayList<BestDealDomain> items = new ArrayList<>();
        items.add(new BestDealDomain("orange","Fresh Orange",6.2,"With its vibrant orange hue and a burst of refreshing citrus flavor, our healthy app shop introduces a delightful selection of nutrient-packed beverages and snacks, enhancing your well-being with every sip and bite.",4.5));
        items.add(new BestDealDomain("apple","Fresh Apple",6.5,"Apples are crisp, sweet fruits known for their high fiber content and rich in essential nutrients. They provide a refreshing and wholesome snack, contributing to heart health and aiding digestion. Apples come in various varieties, offering a range of flavors from sweet to tart.",4.8));
        items.add(new BestDealDomain("pineaplle","Fresh Pineapple",10,"Pineapple is a tropical fruit with a sweet and tangy taste. It is packed with vitamins, minerals, and antioxidants. Known for its juicy texture, pineapple is not only delicious but also promotes digestion and supports the immune system. It adds a tropical flair to any healthy snack or meal.",4));
        items.add(new BestDealDomain("watermelon","Fresh Watermelon",5.1,"Watermelon is a hydrating and refreshing fruit with a high water content. Its vibrant red flesh is sweet and juicy, making it a delightful summer treat. Beyond its delicious taste, watermelon is rich in vitamins A and C, and it provides hydration, promoting healthy skin and overall well-being.",4.9));
        items.add(new BestDealDomain("berry","FreshCherry",6,"Cherries are small, flavorful fruits with a sweet and slightly tart taste. Packed with antioxidants, cherries have been associated with various health benefits, including reducing inflammation and improving sleep. Whether enjoyed fresh or added to dishes, cherries add a burst of color and natural sweetness.",4.5));
        items.add(new BestDealDomain("strawberry","Fresh Strawberry",12,"Strawberries are juicy, red berries that are not only delicious but also packed with vitamins, fiber, and antioxidants. With their sweet taste and vibrant color, strawberries contribute to heart health, support the immune system, and add a nutritious touch to salads, snacks, or desserts.",4.1));
        return items;
    }
}