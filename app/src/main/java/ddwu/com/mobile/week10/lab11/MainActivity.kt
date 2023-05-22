package ddwu.com.mobile.week10.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.week10.lab11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foods = FoodDao().foods
        val adapter = FoodAdapter(foods)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL    // 생략 가능

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        val listener = (object : FoodAdapter.ItemLongClickListener{
            override fun ItemLongClick(view: View, position: Int) {
                AlertDialog.Builder(this).run{
                    setIcon(android.R.drawable.ic_dialog_info)
                    setMessage("정말 삭제하시겠습니까?")
                    setPositiveButton("확인", object: DialogInterfade.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int){
                        
                        }                 
                    })
                    setNegativeButton("취소", null)
                    show()
                }
                Toast.makeText(this@MainActivity, "${foods[position]}", Toast.LENGTH_SHORT).show()
            }

        })
       
            adapter.setItemLongClickListener(listener)

    }
}
