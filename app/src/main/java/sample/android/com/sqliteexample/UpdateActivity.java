package sample.android.com.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText etName, etDept, etNumber;

    private String id, name, dept, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            id = bundle.getString("id");
            name = bundle.getString("name");
            dept = bundle.getString("dept");
            number = bundle.getString("number");
        }

        initView();
    }

    private void initView() {
        etName = findViewById(R.id._name);
        etDept = findViewById(R.id._dept);
        etNumber = findViewById(R.id._number);

        etName.setText(name);
        etDept.setText(dept);
        etNumber.setText(number);
    }

    public void updateBtn(View view) {


        MySqlite mySqlite = new MySqlite(this);

        String newName = etName.getText().toString().trim();
        String newDept = etDept.getText().toString().trim();
        String newNumber = etNumber.getText().toString().trim();

        int res = mySqlite.updateData(id, newName, newDept, newNumber);

        if (res == -1) {
            Toast.makeText(this, "Not updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Update Successfull", Toast.LENGTH_SHORT).show();
        }
    }
}
