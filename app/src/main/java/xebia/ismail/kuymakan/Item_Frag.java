package xebia.ismail.kuymakan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item_Frag extends android.app.ListFragment{
    public static final String ITEM_DETAIL = "com.example.acfan.project.Item Detail";
    public static final String CART_KEY ="com.example.acfan.project.Cart Key";
    private ArrayList<Item> list;
    private ItemAdapter itemAdapter;
    private Item Itemchosen;
    private int itemamountchosen;
    private Intent cartintent;
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        String[] names = {"Nasi Uduk Bu Enas", "Ati dan Ampela", "Bakwan", "Ayam Goreng"};
        int[] images = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4};
        String[] descriptions = {
                "A Nasiuduk is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. Hamburgers may be cooked in a variety of ways, including pan-frying, barbecuing, and flame-broiling.",
                "Ati Amplea is a dish of eggs poached in a sauce of tomatoes, chili peppers, and onions, often spiced with cumin.",
                "Bakwan Cinta is a deep-fried ball or patty made from ground chickpeas, fava beans, or both. Falafel is a traditional Middle Eastern food, commonly served in a pita, which acts as a pocket",
                "Ayam Goreng is an Arab and Israeli meat preparation, where lamb, chicken, turkey, beef, veal, buffalo meat, or mixed meats are placed on a spit, and may be grilled for as long as a day."};
        float[] prices = {20, 15, 13, 17};
        for (int i = 0; i < names.length; i++) {
            list.add(new Item(names[i], images[i], descriptions[i], prices[i]));
        }
        itemAdapter = new ItemAdapter(getActivity(), list);
        setListAdapter(itemAdapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        launchItemDetailActivity(position);
    }

    private void launchItemDetailActivity(int position){
        Item item = (Item)getListAdapter().getItem(position);
        Intent intent=new Intent(getActivity(),ItemDetailActivity.class);
        intent.putExtra("Item",item);
        startActivity(intent);
    }
}