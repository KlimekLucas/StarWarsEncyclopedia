package com.example.rottan.starwarsencyclopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rottan.starwarsencyclopedia.Model.People;
import com.example.rottan.starwarsencyclopedia.Model.Starship;
import com.example.rottan.starwarsencyclopedia.Presenter.PeoplePresenter;
import com.example.rottan.starwarsencyclopedia.Presenter.StarshipPresenter;
import com.example.rottan.starwarsencyclopedia.View.PeopleView;
import com.example.rottan.starwarsencyclopedia.View.StarshipsView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StarshipsView, PeopleView {
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


        // final String name = "costam";
        // Maybe it's best to call it on onResume()

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
                int categoryNo = radioGroup.indexOfChild(rbSelected) + 1;
                String peopleURL = "https://swapi.co/api/people/?search=";
                String starshipURL = "https://swapi.co/api/starships/?search=";

                System.out.println(categoryNo + "                   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                if (categoryNo == 2) {
                    String ship = starshipURL + et2.getText();
                    starshipPresenter.getSearchedStarship(ship);
                } else if (categoryNo == 1) {
                    String personUrl = peopleURL + et2.getText();
                    peoplePresenter.getSearchedPerson(personUrl);

                } else {
                    textViewResult.setText("chose category");
                }
            }


        });
    }

    @Override
    public void starshipsReady(List<Starship> starships) {
        textViewResult.setText("");
        for (Starship starship : starships) {
            textViewResult.append(starship.getName()+'\n');
            textViewResult.append(starship.getCargoCapacity()+'\n');
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void peopleReady(List<People> people) {
        System.out.println(people.size());
        if (people.size() == 1) {
            textViewResult.setText("niema takiego numeru");
            System.out.println("niema takiego numeru");
        } else {
            textViewResult.setText("");
            for (People person : people) {
                textViewResult.append(person.getName()+'\n');
                textViewResult.append(person.getGender()+'\n');
            }
        }
    }
}




/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.tv_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<People> call = jsonPlaceHolderApi.getPerson();

        call.enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    System.out.println(".......................................................response code");
                    return;
                }
                People person = response.body();

                textViewResult.append(person.getName());


            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                textViewResult.setText(t.getMessage());
                System.out.println(t.getMessage());
                System.out.println("......................................on failure");
            }
        });
    }
}








    /*
    public TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textViewResult.findViewById(R.id.tv_result);
        System.out.println("poczatek....................................................");
        System.out.println("poczatek....................................................");
        System.out.println("poczatek....................................................");
        System.out.println("poczatek....................................................");
        System.out.println("poczatek....................................................");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call <List<People>> call = jsonPlaceHolderApi.getPeople();

        call.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
            if (!response.isSuccessful()){
                textViewResult.setText("code " + response.code());
                System.out.println("dupa");
                System.out.println("dupa");
                System.out.println("dupa");
                System.out.println("dupa");
                System.out.println("dupa");
                System.out.println("failure");
                return;
            }
            List<People> people = response.body();
                System.out.println("poszło");
                System.out.println("poszło");
                System.out.println("poszło");
                System.out.println("poszło");
                System.out.println("poszło");
                System.out.println("poszło");

                for (People person : people) {
                    String content = "";
                    content += person.getName() + "\n";
                    content += person.getGender();

                    textViewResult.append(content);
                    System.out.println(content);

                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
//            textViewResult.setText(t.getMessage());
                System.out.println("..................................................james ");
                System.out.println(t.getMessage() + "wiadomosc jamesa");
            }
        });


    }

}
*/