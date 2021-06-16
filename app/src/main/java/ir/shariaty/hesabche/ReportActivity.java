package ir.shariaty.hesabche;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import ir.shariaty.hesabche.databinding.ActivityReportBinding;

public class ReportActivity extends DrawerActivity {

    ActivityReportBinding binding;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReportBinding.inflate(getLayoutInflater());

        database = FirebaseFirestore.getInstance();

        ArrayList<Income> incomes = new ArrayList<>();
        ReportAdapter adapter = new ReportAdapter(this, incomes);

        database.collection("categories")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        incomes.clear();
                        for (DocumentSnapshot snapshot : value.getDocuments()) {
                            Income model = snapshot.toObject(Income.class);
                            //model.incomeId(snapshot.getId());
                            incomes.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}