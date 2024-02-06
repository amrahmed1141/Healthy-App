package com.example.healthyapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.healthyapp.Adapter.SimilarAdapter;
import com.example.healthyapp.Domain.BestDealDomain;
import com.example.healthyapp.R;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerViewSimilar;
    private RecyclerView.Adapter similarAdapter;
    private TextView priceTxt, titleTxt, descriptionTxt, ratingTxt;
    private ImageView itemImg, btnBack;
    private RatingBar ratingBar;
    private TextView plusBtn, minusBtn, weightTxt, totalTxt;
    private int weight = 1;
    private BestDealDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getBundles();
        initView();
        setVariable();
        initSimilarList();
    }

    private void initSimilarList() {
        recyclerViewSimilar = findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        similarAdapter = new SimilarAdapter(new MainActivity2().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }



    private void setVariable() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        int drawableResourseId =getResources().getIdentifier(object.getImgpath(),"drawable",DetailsActivity.this.getPackageName());

        Glide.with(DetailsActivity.this)
                        .load(drawableResourseId)
                                .into(itemImg);


        priceTxt.setText(object.getPrice()+"$/Kg");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingBar.setRating((float) object.getRate());
        ratingTxt.setText("("+object.getRate()+")");
        totalTxt.setText(weight*object.getPrice()+"$");

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight =weight+1;
                weightTxt.setText(weight+"Kg");
                totalTxt.setText(weight*object.getPrice()+"$");
            }
        });
              minusBtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (weight>1){
                          weight = weight-1;
                          weightTxt.setText(weight+"Kg");
                          totalTxt.setText(weight*object.getPrice()+"$");
                      }
                  }
              });
    }

    private void initView() {
        priceTxt=findViewById(R.id.priceKgTxt);
       titleTxt=findViewById(R.id.titleTxt);
       descriptionTxt=findViewById(R.id.descriptionTxt);
        ratingBar=findViewById(R.id.ratingBar2);
        ratingTxt=findViewById(R.id.ratingTxt);
        itemImg = findViewById(R.id.itemImg);
       btnBack=findViewById(R.id.btnBack);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        weightTxt = findViewById(R.id.weightTxt);
       totalTxt = findViewById(R.id.totalTxt);


    }

    private void getBundles() {
        object=(BestDealDomain) getIntent().getSerializableExtra("object");
    }
}