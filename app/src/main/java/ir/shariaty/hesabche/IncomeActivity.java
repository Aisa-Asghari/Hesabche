package ir.shariaty.hesabche;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import ir.shariaty.hesabche.databinding.ActivityIncomeBinding;

public class IncomeActivity extends DrawerActivity {

    ActivityIncomeBinding binding;
    FirebaseFirestore database;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityIncomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseFirestore.getInstance();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Inserting Your Income..");

        RunAnimation();

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String incomeId,amount, cat, title, date, desc;

                incomeId="";
                amount = binding.amountBox.getText().toString();
                cat = binding.categoryBox.getText().toString();
                title = binding.titleBox.getText().toString();
                date = binding.dateBox.getText().toString();
                desc = binding.descBox.getText().toString();

                Income income = new Income(amount, cat, title, date, desc);

                dialog.show();

                database.collection("incomes")
                        .add(income)
                        .addOnFailureListener(e -> {
                            dialog.dismiss();
                            Toast.makeText(IncomeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        })
                        .addOnSuccessListener(documentReference -> {
                                    dialog.dismiss();
                                    Toast.makeText(IncomeActivity.this, "Income Inserted Successfully!", Toast.LENGTH_LONG).show();
                                }
                        );
            }
        });
    }
    private void RunAnimation() {
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        alpha.reset();
        binding.cardView.clearAnimation();
        binding.cardView.startAnimation(alpha);
    }
}