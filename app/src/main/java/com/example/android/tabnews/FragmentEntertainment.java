package com.example.android.tabnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentEntertainment extends Fragment {
    private RecyclerView recyclerView;
    private List<Data> data = new ArrayList<>();
    String News_url = "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&pageSize=30&apiKey=bcb826c41a09430286e402c029ef3c63";
    RecyclerviewAdapter adapter;
    private RequestQueue mReq;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sports_fragment, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new RecyclerviewAdapter(getContext(), data, new ItemClicked() {
            @Override
            public void clickListener(int pos) {
                Data data1 = data.get(pos);
                String url = data1.getUrl();
                Intent intent = new Intent(getContext(), Webview.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReq = Volley.newRequestQueue(getActivity().getApplicationContext());
        parseJson();

    }

    private void parseJson() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, News_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject articles = jsonArray.getJSONObject(i);
                        String title = articles.getString("title");
                        String datee = articles.getString("publishedAt");
                        String iUrl = articles.getString("urlToImage");
                        String mainUrl = articles.getString("url");

                        JSONObject source = articles.getJSONObject("source");
                        String name = source.getString("name");

                        String date;
                        date = datee.substring(8, 10) + "-" + datee.substring(5, 7) + "-" + datee.substring(0, 4);

                        data.add(new Data(title, name, iUrl, date, mainUrl));
                    }
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mReq.add(request);


    }
}
