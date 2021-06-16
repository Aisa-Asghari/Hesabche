package ir.shariaty.hesabche;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.shariaty.hesabche.databinding.ItemReportBinding;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    Context context;
    ArrayList<Income> incomes;
    ArrayList<Outgo> outgoes;

    public ReportAdapter(Context context, ArrayList<Income> incomes) {
        this.context = context;
        this.incomes = incomes;
        this.outgoes = outgoes;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_report, null);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Income income = incomes.get(position);

        holder.binding.descLb.setText(income.getDesc());
        holder.binding.amountLb.setText(income.getAmount());
        holder.binding.dateLb.setText(income.getDate());
        holder.binding.titleLb.setText(income.getTitle());
        holder.binding.catLb.setText(income.getCat());

        //Outgo outgo = outgoes.get(position);

        //holder.binding.descLb.setText(outgo.getDesc());
        //holder.binding.amountLb.setText(outgo.getAmount());
        //holder.binding.dateLb.setText(outgo.getDate());
        //holder.binding.titleLb.setText(outgo.getTitle());
        //holder.binding.catLb.setText(outgo.getCat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return incomes.size() + outgoes.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {

        ItemReportBinding binding;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReportBinding.bind(itemView);
        }
    }
}
