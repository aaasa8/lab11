package ddwu.com.mobile.week10.lab11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ddwu.com.mobile.week10.lab11.databinding.ListItemBinding

class FoodAdapter (val foods: ArrayList<FoodDto>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

   interface ItemLongClickListener {
        fun ItemLongClick(view: View, position: Int)
    }

    lateinit var listener : ItemLongClickListener


    fun setItemLongClickListener(listener: ItemLongClickListener){
        this.listener = listener
    }

    // RecyclerView 에 표시할 전체 뷰의 개수 == 원본 데이터의 개수, 데이터의 개수 확인이 필요할 때 호출
    override fun getItemCount(): Int = foods.size

    // 각 항목의 뷰를 보관하는 Holder, 각 item view의 view holder 생성 시 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return FoodViewHolder(itemView, listener)
    }


    // 항목의 뷰를 생성한 후 멤버변수로 보관하는 ViewHolder
    class FoodViewHolder(view: View, listener: ItemLongClickListener) : RecyclerView.ViewHolder(view){
         init{
            view.setOnLongClickListener{
                listener.ItemLongClick(it, adapterPosition)
                true
            }
        }

        val photo = view.findViewById<ImageView>(R.id.ivPhoto)
        val food = view.findViewById<TextView>(R.id.tvFood)
        val count = view.findViewById<TextView>(R.id.tvCount)

    }

    // Holder 에 보관중인 View 에 원본 데이터 연결, 각 item view의 항목에 데이터 결합 시 호출
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.photo.setImageResource(foods[position].photo)
        holder.food.text = foods[position].food
        holder.count.text = foods[position].count.toString()

    }

}
