package com.example.rottan.starwarsencyclopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rottan.starwarsencyclopedia.Model.People;
import com.example.rottan.starwarsencyclopedia.Model.Planet;
import com.example.rottan.starwarsencyclopedia.Model.Starship;
import com.example.rottan.starwarsencyclopedia.Presenter.PeoplePresenter;
import com.example.rottan.starwarsencyclopedia.Presenter.PlanetPresenter;
import com.example.rottan.starwarsencyclopedia.Presenter.StarshipPresenter;
import com.example.rottan.starwarsencyclopedia.RecyclerView.ExampleItem;
import com.example.rottan.starwarsencyclopedia.RecyclerView.SWAdapter;
import com.example.rottan.starwarsencyclopedia.View.PeopleView;
import com.example.rottan.starwarsencyclopedia.View.PlanetsView;
import com.example.rottan.starwarsencyclopedia.View.StarshipsView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StarshipsView, PeopleView, PlanetsView {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    private static final String baseUrl = "https://swapi.co/api/";
    private TextView textViewResult;
    private EditText et2;

    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewResult = findViewById(R.id.tv_result);
        et2 = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        button = findViewById(R.id.button);
        final StarshipPresenter starshipPresenter = new StarshipPresenter(this);
        final PeoplePresenter peoplePresenter = new PeoplePresenter(this);
        final PlanetPresenter planetPresenter = new PlanetPresenter(this);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
                int categoryNo = radioGroup.indexOfChild(rbSelected) + 1;
                String peopleURL = "https://swapi.co/api/people/?search=";
                String starshipURL = "https://swapi.co/api/starships/?search=";
                String planetsUrl = "https://swapi.co/api/planets/?search=";

                System.out.println(categoryNo + "                   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                if (categoryNo == 2) {
                    String ship = starshipURL + et2.getText();
                    starshipPresenter.getSearchedStarship(ship);
                } else if (categoryNo == 1) {
                    String personUrl = peopleURL + et2.getText();
                    peoplePresenter.getSearchedPerson(personUrl);

                } else if (categoryNo == 3) {
                    String planetUrl = planetsUrl + et2.getText();
                    planetPresenter.getSearchedPlantet(planetUrl);
                } else {
                    textViewResult.setText("chose category");
                }
            }


        });
    }

    @Override
    public void starshipsReady(List<Starship> starships) {
        textViewResult.setText("znaleziono " + starships.size() + "wyników");
        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        if (starships.size() == 0) {
            textViewResult.setText("nic nie znaleziono");
        }
        for (Starship starship : starships) {
            exampleItems.add(new ExampleItem(R.drawable.ic_star, starship.getName(), starship.getManufacturer()));

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            adapter = new SWAdapter(exampleItems);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void peopleReady(List<People> people) {
        textViewResult.setText("znaleziono " + people.size() + " wyników");
        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        if (people.size() == 0) {
            textViewResult.setText("nic nie zaleziono");
        } else {
            for (People person : people) {

                exampleItems.add(new ExampleItem(R.drawable.ic_star, person.getName(), person.getBirtYear()));

                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(this);
                adapter = new SWAdapter(exampleItems);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    public void planestReady(List<Planet> planets) {
        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        textViewResult.setText("znaleziono " + planets.size() + " wyników");
        if (planets.size() == 0) {
            textViewResult.setText("nic nie znaleziono");
        }
        for (Planet planet : planets) {
            exampleItems.add(new ExampleItem(R.drawable.ic_star, planet.getName(), planet.getTerrain()));
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            adapter = new SWAdapter(exampleItems);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
}
