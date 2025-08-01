package com.example.aiga_hackathon.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.buy.BuyAdapter;
import com.example.aiga_hackathon.client.buy.ShopModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListAdapter;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListViewModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BuyFragment extends Fragment {

    private BuyAdapter buyAdapter;
    private List<ShopModel> fullShopList;
    public static BuyFragment newInstance(String param1, String param2) {
        BuyFragment fragment = new BuyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        RecyclerView buyRecycler = view.findViewById(R.id.buy_recycler);
        Spinner category = view.findViewById(R.id.category_spinner);
        EditText search = view.findViewById(R.id.search_input);
        //buyViewModel = new ViewModelProvider(this).get(BuyViewModel.class);

        buyRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        buyRecycler.setHasFixedSize(true);

        buyAdapter = new BuyAdapter(new ArrayList<>());
        buyRecycler.setAdapter(buyAdapter);

        fullShopList = new ArrayList<>();
        fullShopList.add(new ShopModel(R.drawable.product_example,
                "Champions League Brazil", 14.64F, true, 5.20f,
                "Astana", "hightypeuk 100% positive (411)"));
        fullShopList.add(new ShopModel(R.drawable.product_example_2,
                "AIGA x AL LEONE ( black )", 110.69F, true, 4.40f,
                "Aktau", "vainshark 100% positive (1K)"));
        buyAdapter.setShopList(fullShopList);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterList(s.toString());
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String filter = parent.getItemAtPosition(pos).toString();
                List<ShopModel> filtered = new ArrayList<>(fullShopList);

                switch (filter) {
                    case "Brand New":
                        filtered.removeIf(item -> !item.isNew());
                        break;
                    case "Old Collection":
                        filtered.removeIf(ShopModel::isNew);
                        break;
                    case "Price: Low to High":
                        filtered.sort(Comparator.comparing(ShopModel::getCost));
                        break;
                    case "Price: High to Low":
                        filtered.sort((a, b) -> Float.compare(b.getCost(), a.getCost()));
                        break;
                }

                buyAdapter.setShopList(filtered);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        buyAdapter.notifyDataSetChanged();
        return view;
    }

    private void filterList(String query) {
        List<ShopModel> filtered = new ArrayList<>();
        for (ShopModel item : fullShopList) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())
                    || item.getDesc().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(item);
            }
        }
        buyAdapter.setShopList(filtered);
    }
}