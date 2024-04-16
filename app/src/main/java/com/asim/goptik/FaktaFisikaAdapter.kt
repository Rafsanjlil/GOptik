import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asim.goptik.FaktaFisika
import com.asim.goptik.databinding.ItemFaktaBinding

class FaktaFisikaAdapter(private val factsList: List<FaktaFisika>) :
    RecyclerView.Adapter<FaktaFisikaAdapter.FactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val binding = ItemFaktaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val currentFact = factsList[position]
        holder.bind(currentFact)
    }

    override fun getItemCount() = factsList.size

    inner class FactViewHolder(private val binding: ItemFaktaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fact: FaktaFisika) {
            binding.fact = fact
            binding.executePendingBindings()
        }
    }
}
