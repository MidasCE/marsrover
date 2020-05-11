class MarsRover(var x: Int, var y: Int, var direction: Compass) {

    fun updateDirection(instruction: INSTRUCTION) {
        direction = when (direction) {
            Compass.N -> {
                instruction.takeIf { it == INSTRUCTION.L }?.let { Compass.W } ?: Compass.E
            }
            Compass.S -> {
                instruction.takeIf { it == INSTRUCTION.L }?.let { Compass.E } ?: Compass.W
            }
            Compass.W -> {
                instruction.takeIf { it == INSTRUCTION.L }?.let { Compass.S } ?: Compass.N
            }
            Compass.E -> {
                instruction.takeIf { it == INSTRUCTION.L }?.let { Compass.N } ?: Compass.S
            }
        }
    }

    fun move(plateauArea: PlateauArea) {
        val isInYCoordinate = this.y >= 0 && this.y <= plateauArea.y
        val isInXCoordinate = this.x >= 0 && this.x <= plateauArea.x
        if (direction == Compass.N && isInYCoordinate) {
            y++
        } else if (direction == Compass.S && isInYCoordinate) {
            y--
        } else if (direction == Compass.W && isInXCoordinate) {
            x--
        } else if (direction == Compass.E && isInXCoordinate) {
            x++
        }
    }
}
