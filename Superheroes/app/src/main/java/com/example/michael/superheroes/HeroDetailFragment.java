package com.example.michael.superheroes;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.AdapterView;



/**
 * A simple {@link Fragment} subclass.
 */
public class HeroDetailFragment extends Fragment implements View.OnClickListener {


    public HeroDetailFragment() {
        // Required empty public constructor
    }

    public interface ButtonClickListener{
        public void addheroclicked(View view);
    }

    private ButtonClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState !=null){
            universeId = savedInstanceState.getLong("universeId");
        }

        if (Hero.heroes[0].getSuperheroes().size() == 0) {
            Hero.heroes[0].loadHeroes(getActivity(), 0);
        }
        if (Hero.heroes[1].getSuperheroes().size() == 0) {
            Hero.heroes[1].loadHeroes(getActivity(), 1);
        }

        return inflater.inflate(R.layout.fragment_hero_detail, container, false);
    }

    private ArrayAdapter<String> adapter;

    @Override public void onStart(){
        super.onStart();

        View view = getView();
        ListView listHeroes = (ListView) view.findViewById(R.id.herolistView);

        // get hero data
        ArrayList<String> herolist = new ArrayList<String>();
        herolist = Hero.heroes[(int) universeId].getSuperheroes();
        // Hero.heroes[0].getSuperheroes();

        //set the array adapter
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, herolist);

        listHeroes.setAdapter(adapter);

        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        registerForContextMenu(listHeroes);
    }

    @Override public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("universeId", universeId);
    }

    @Override public void onAttach(Context context){
        super.onAttach(context);
        //attaches the context to the listener
        if (context instanceof ButtonClickListener) {
            listener = (ButtonClickListener) context; //causes crash
        }
    }

    @Override public void onClick(View view){
        if (listener !=null){
            listener.addheroclicked(view);
        }
    }

    public void addHero(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Add Hero");
        dialog.setCancelable(true);
        final EditText editText = (EditText) dialog.findViewById(R.id.editTextHero);
        Button button = (Button) dialog.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heroName = editText.getText().toString();
                // add hero
                Hero.heroes[(int) universeId].getSuperheroes().add(heroName);
                //refresh the list view
                HeroDetailFragment.this.adapter.notifyDataSetChanged();
                Hero.heroes[(int) universeId].storeHeroes(getActivity(), universeId);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        String heroname = adapter.getItem(adapterContextMenuInfo.position);
        menu.setHeaderTitle("Delete " + heroname);
        menu.add(1, 1, 1, "Yes");
        menu.add(2, 2, 2, "No");
    }

    @Override public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == 1) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Hero.heroes[(int) universeId].getSuperheroes().remove(info.position);
            HeroDetailFragment.this.adapter.notifyDataSetChanged();
        }
        return true;
    }

    private long universeId;

    public void setUniverse(long id) {
        this.universeId = id;
    }

}
