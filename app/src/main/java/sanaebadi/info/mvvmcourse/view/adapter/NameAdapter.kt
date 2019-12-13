package sanaebadi.info.mvvmcourse.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*
import sanaebadi.info.mvvmcourse.databinding.RowItemBinding
import sanaebadi.info.mvvmcourse.model.NameModel

class NameAdapter(private var names: ArrayList<NameModel>) :
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    inner class NameViewHolder(
        private var binding: RowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nameModel: NameModel) {
            binding.name = nameModel
            with(binding.root) {
                txt_name.text = nameModel.name
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context))
        return NameViewHolder(binding)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) =
        holder.bind(names[position])

    fun reloadData(nameList: ArrayList<NameModel>) {
        names = nameList
        notifyDataSetChanged()
    }
}