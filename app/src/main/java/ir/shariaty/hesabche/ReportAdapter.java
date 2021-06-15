package ir.shariaty.hesabche;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.shariaty.hesabche.databinding.ItemReportBinding;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder>{

    Context context;
    ArrayList<Income> incomes;

    public ReportAdapter(Context context, ArrayList<Income> incomes) {
        this.context = context;
        this.incomes = incomes;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_report, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Income income = incomes.get(position);

        holder.binding.amountLb.setText(holder.binding.amountLb.getText()+income.getAmount());
        holder.binding.titleLb.setText(holder.binding.titleLb.getText()+income.getTitle());
        holder.binding.dateLb.setText(holder.binding.dateLb.getText()+income.getDate());
        holder.binding.descLb.setText(holder.binding.descLb.getText()+income.getDesc());

    }

    @Override
    public int getItemCount() {
        return incomes.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {

        ItemReportBinding binding;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReportBinding.bind(itemView);
        }
    }
}
