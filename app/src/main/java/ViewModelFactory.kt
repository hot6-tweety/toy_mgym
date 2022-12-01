import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toy.mgym.AssetLoader
import com.toy.mgym.repository.FoodAssetDatasource
import com.toy.mgym.repository.FoodRepository
import com.toy.mgym.ui.search.SearchViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                val repository = FoodRepository(FoodAssetDatasource((AssetLoader(context))))
                SearchViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to crete ViewModel: ${modelClass.name}")
            }
        }
    }
}