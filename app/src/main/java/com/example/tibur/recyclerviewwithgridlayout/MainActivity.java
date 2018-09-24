package com.example.tibur.recyclerviewwithgridlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //1º) Quiero mostrar un conjunto de objetos. (P.Ej: ArrayList<Student>)
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Samuel", "Marrero"));
        students.add(new Student("Francis", "Sosa"));
        students.add(new Student("Gustavo", "Vega"));
        students.add(new Student("Juan", "Sosa"));
        students.add(new Student("Jacinto", "Ramos Moreno"));
        students.add(new Student("Javier", "Santana"));
        students.add(new Student("Olga", "Cruz"));

        //2º) Uso un RecyclerView para mostrar un conjunto de items en general.
        RecyclerView recyclerViewStudents = findViewById(R.id.recyclerViewStudents);

        //3º) Indico la disposición en la que se mostrarán los items en el RecyclerView (P.Ej: GridLayout de 2 columnas)
        RecyclerView.LayoutManager layoutManagerStudents = new GridLayoutManager(this, 2);
        recyclerViewStudents.setLayoutManager(layoutManagerStudents);

        //4º) Asigno al RecyclerView el adaptador que relaciona a cada item con su objeto a mostrar.
        StudentsAdapter studentsAdapter = new StudentsAdapter(students);
        recyclerViewStudents.setAdapter(studentsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
