package ir.shariaty.hesabche;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import ir.shariaty.hesabche.databinding.ActivityOutgoBinding;

public class OutgoActivity extends AppCompatActivity {

    ActivityOutgoBinding binding;
    FirebaseFirestore database;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOutgoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseFirestore.getInstance();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Inserting Your Outgo..");

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amount, cat, title, date, desc;

                amount = binding.amountBox.getText().toString();
                cat = binding.categoryBox.getText().toString();
                title = binding.titleBox.getText().toString();
                date = binding.dateBox.getText().toString();
                desc = binding.descBox.getText().toString();

                Outgo outgo = new Outgo(amount, cat, title, date, desc);

                dialog.show();

                database.collection("outgoes")
                        .add(outgo)
                        .addOnFailureListener(e -> {
                            dialog.dismiss();
                            Toast.makeText(OutgoActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        })
                        .addOnSuccessListener(documentReference -> {
                                    dialog.dismiss();
                                    Toast.makeText(OutgoActivity.this, "Outgo Inserted Successfully!", Toast.LENGTH_LONG).show();
                                }
                        );
            }
        });
    }
}