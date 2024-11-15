package com.mrg.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstMovieList;
//    String[] movieName = {"Iron Man", "Captain America: Civil War", "Man of Steel", "Thor: Ragnarok",
//             "The Dark Knight", "The Batman", "Spider-man: Homecoming", "Avengers: Endgame",
//            "Spider-man: No Way Home"};
    String[] movieName ;

//    String[] movieYear = {"2008", "2016", "2013", "2017", "2008", "2022", "2017", "2019", "2021"};
    String[] movieYear;

//    String[] movieRating = {"IMDB: 7.9/10","IMDB: 7.8/10", "IMDB: 7.1/10", "IMDB: 7.9/10", "IMDB: 9/10",
//            "IMDB: 7.8/10", "IMDB: 7.4/10", "IMDB: 8.4/10", "IMDB: 8.2/10"};
    String[] movieRating;

    int[] moviePoster = {R.drawable.ironman2008, R.drawable.captainamericacivilwar2016,
            R.drawable.manofsteel2013, R.drawable.thorragnarok2017, R.drawable.thedarkknight2008,
            R.drawable.thebatman2022, R.drawable.spidermanhomecoming2017, R.drawable.avengersendgame2019,
            R.drawable.spidermannowayhome2021};
//    int[] moviePoster;

//    String[] movieDirector = {"Director: Jon Favreau","Directors: Anthony and Joe Russo",
//            "Director: Zack Snyder", "Director: Taika Waititi","Director: Christopher Nolan",
//            "Director: Matt Reeves",
//            "Director: Jon Watts", "Directors: Joe and Anthony Russo","Director: Jon Watts"};
    String[] movieDirector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstMovieList = findViewById(R.id.lst_list_view);
        movieName = getResources().getStringArray(R.array.movieName);
        movieYear = getResources().getStringArray(R.array.movieYear);
        movieRating = getResources().getStringArray(R.array.movieRating);
//        moviePoster = getResources().getIntArray(R.array.moviePoster);
        movieDirector = getResources().getStringArray(R.array.movieDirector);

        lstMovieList.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return movieName.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(MainActivity.this).
                            inflate(R.layout.item_list_view_movie_name, viewGroup, false);
                }
                TextView txtMovieName = view.findViewById(R.id.txt_movie_name);
                TextView txtMovieYear = view.findViewById(R.id.txt_movie_year);
                TextView txtMovieRating = view.findViewById(R.id.txt_movie_rating);
                ImageView imgMoviePoster = view.findViewById(R.id.img_movie_poster);

                txtMovieName.setText(movieName[position]);
                txtMovieYear.setText(movieYear[position]);
                txtMovieRating.setText(movieRating[position]);
                imgMoviePoster.setImageResource(moviePoster[position]);

                    return view;
            }


        });


//        lstMovieList.setAdapter(new ArrayAdapter<String>(MainActivity.this,
//                R.layout.item_list_view_movie_name,R.id.txt_movie_name, movieName));



        lstMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,movieDirector[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}