import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

@Serializable
data class Price (
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("DateTime")
    val dateTime: String,
    @SerializedName("PriceNoTax")
    val priceNoTax: Float,
    @SerializedName("PriceWithTax")
    val priceWithTax: Float
){
    val price:Float = priceWithTax * 100
}


interface ApiService {

    @GET("Today")
    suspend fun getPrices(): List<Price>

}

interface ApiHelper {

    suspend fun getPrices(): List<Price>

}

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getPrices() = apiService.getPrices()

}


object RetrofitBuilder {

    private const val BASE_URL = "https://api.spot-hinta.fi/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}
