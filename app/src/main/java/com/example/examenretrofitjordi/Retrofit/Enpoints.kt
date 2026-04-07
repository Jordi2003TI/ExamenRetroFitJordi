package com.example.examenretrofitjordi.Retrofit
import com.example.examenretrofitjordi.DataClasses.HttpValidationError
import com.example.examenretrofitjordi.DataClasses.Material
import com.example.examenretrofitjordi.DataClasses.Reserva
import com.example.examenretrofitjordi.DataClasses.Usuari
import com.example.examenretrofitjordi.DataClasses.ValidationError
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Objects

interface Enpoints {
    @GET("/")
    suspend fun home(): retrofit2.Response<HttpValidationError>

    @GET("/usuaris/")
    suspend fun CrearUsusari(
        @Body usuario: Usuari
    ): retrofit2.Response<ValidationError>

    @GET("/materials/")
    suspend fun allMaterials():retrofit2.Response<List<Material>>
    @GET("/usuaris/{id}")
    suspend fun getUsuari(
        @Path("id")id: Long
    ):retrofit2.Response<ValidationError>

    @PUT("/materials/{id}")
    suspend fun modificarMaterial(
        @Path("id")id: Long
    ):retrofit2.Response<ValidationError>

    @POST
    suspend fun login(
        @Body usuari: Usuari
    ):retrofit2.Response<ValidationError>

    @DELETE("/materials/{id}")
    suspend fun deleteMaterialById(
        @Path("id")id: Long
    ):retrofit2.Response<ValidationError>

    @POST("/reserves/")
    suspend fun reservasPost(
        @Body resreva: Reserva
    ):retrofit2.Response<ValidationError>

    @GET("/reserves/{idusuari}/{idmaterial}/{datareserva}")
    suspend fun getReserva(
        @Path("idusari")idUsuari:Long,
        @Path("idMaterial")idMaterial: Long,
        @Path("datareserva")datareserva: Long
    ):retrofit2.Response<ValidationError>

    @POST("/reserves/{idusuari}/{idmaterial}/{datareserva}")
    suspend fun putReserva(
        @Path("idusari")idUsuari:Long,
        @Path("idMaterial")idMaterial: Long,
        @Path("datareserva")datareserva: Long
    ):retrofit2.Response<ValidationError>

    @POST("/reserves/{idusuari}/{idmaterial}/{datareserva}")
    suspend fun deleteReserva(
        @Path("idusari")idUsuari:Long,
        @Path("idMaterial")idMaterial: Long,
        @Path("datareserva")datareserva: Long
    ):retrofit2.Response<ValidationError>

    @POST("/reserves/{idusuari}/{idmaterial}/{datareserva}")
    suspend fun getReservaUsuari(
        @Path("idusari")idUsuari:Long
    ):retrofit2.Response<ValidationError>

}