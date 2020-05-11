package data

import PlateauArea
import com.google.gson.annotations.SerializedName

data class InputDto (
        @SerializedName("topRightCorner") val topRightCorner: PlateauArea,
        @SerializedName("roverPosition") val roverPosition: PositionDto,
        @SerializedName("roverDirection") val roverDirection: String,
        @SerializedName("movements") val movements: String
)
