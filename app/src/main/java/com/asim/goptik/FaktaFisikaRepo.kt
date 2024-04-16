import android.content.Context
import com.asim.goptik.FaktaFisika
import java.util.Calendar

class FaktaFisikaRepo(private val context: Context) {

    fun getCurrentFact(): FaktaFisika {
        // Get the last displayed fact index from SharedPreferences
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val lastDisplayedFactIndex = sharedPreferences.getInt("lastDisplayedFactIndex", -1)

        // Populate your facts list with dummy data from PhysicsFact class
        val factsList = FaktaFisika.getDummyData()

        // Determine which fact to display based on the current date and last displayed fact index
        val calendar = Calendar.getInstance()
        val todayFactIndex = calendar.get(Calendar.DAY_OF_MONTH) % factsList.size
        val factIndex = if (lastDisplayedFactIndex == todayFactIndex) (todayFactIndex + 1) % factsList.size else todayFactIndex

        // Save the current fact index to SharedPreferences
        with(sharedPreferences.edit()) {
            putInt("lastDisplayedFactIndex", factIndex)
            apply()
        }

        return factsList[factIndex]
    }
}

