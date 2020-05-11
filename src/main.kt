import com.google.gson.Gson
import data.InputDto


fun main() {
    val json = "{\n" +
            "\"topRightCorner\": {\n" +
            "\"x\" : 5,\n" +
            "\"y\" : 5\n" +
            "},\n" +
            "\"roverPosition\": {\n" +
            "\"x\" : 1,\n" +
            "\"y\" : 2\n" +
            "},\n" +
            "\"roverDirection\": \"N\",\n" +
            "\"movements\" : \"LMLMLMLMM\"\n" +
            "}"
    val gson = Gson()
    val input = gson.fromJson(json, InputDto::class.java)

    val marsRover = createMarsRover(input)

    marsRover.processMarsRoverInstruction(input.topRightCorner, input.movements)
    println("${marsRover.x} ${marsRover.y} ${marsRover.direction.name}")
}

fun createMarsRover(input: InputDto): MarsRover {
    return MarsRover(input.roverPosition.x, input.roverPosition.y, Compass.valueOf(input.roverDirection))
}

fun MarsRover.processMarsRoverInstruction(plateauArea: PlateauArea, instructions: String) {

    instructions.forEach { instruction ->
        if (INSTRUCTION.valueOf(instruction.toString()) == INSTRUCTION.L || INSTRUCTION.valueOf(instruction.toString()) == INSTRUCTION.R) {
            updateDirection(INSTRUCTION.valueOf(instruction.toString()))
        } else if (INSTRUCTION.valueOf(instruction.toString()) == INSTRUCTION.M) {
            move(plateauArea)
        }
    }
}