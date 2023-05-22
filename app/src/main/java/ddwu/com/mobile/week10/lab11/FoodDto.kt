package ddwu.com.mobile.week10.lab11

class FoodDto (val photo : Int, val food : String, var count: Int) {
    override fun toString() = "$food ($count)"
}