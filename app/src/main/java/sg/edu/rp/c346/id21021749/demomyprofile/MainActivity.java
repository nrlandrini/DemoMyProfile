package sg.edu.rp.c346.id21021749.demomyprofile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Get user input from EditText and store in a variable
        String strName = etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());
        // Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // Obtain an instance of SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        // Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // Retrieve saved data from SharedPreferences
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0);
        // Update the UI element with the value
        etName.setText(strName);
        etGPA.setText(gpa + "");
    }
}