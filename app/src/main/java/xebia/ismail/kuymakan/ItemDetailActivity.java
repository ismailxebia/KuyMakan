package xebia.ismail.kuymakan;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ItemDetailActivity extends AppCompatActivity{
    ItemDetailFragment itemDetailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detailed);
        createFragment();
    }

    private void createFragment(){

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        itemDetailFragment=new ItemDetailFragment();
        fragmentTransaction.add(R.id.itemcontainer,itemDetailFragment,"ITEM_DETAIL_FRAGMENT");
        fragmentTransaction.commit();
    }

    public void count(View v){
        itemDetailFragment.count(v);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
