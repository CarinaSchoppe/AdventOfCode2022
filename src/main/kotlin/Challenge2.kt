fun main() {
    var lines = object {}.javaClass.getResourceAsStream("challenge2.txt")?.bufferedReader()?.readLines()
    val rounds = lines?.map {
        Pair<String, String>(it.split(" ")[0], it.split(" ")[1])
    }
    var sum = 0
    rounds?.forEach {
        val opponent = it.first
        val mine = it.second
        //mine, opponent
        //x,a = rock, b,y = paper, c,z = sissors
        //win + 6p, draw +3 points, lose + 0 points
        sum += when (mine to opponent) {
            "X" to "C" -> 6
            "X" to "B" -> 0
            "Y" to "A" -> 6
            "Y" to "C" -> 0
            "Z" to "A" -> 0
            "Z" to "B" -> 6
            else -> 3
        }
        sum += when (mine) {
            "X" -> 1
            "Y" -> 2
            "Z" -> 3
            else -> 0
        }

    }
    print(sum)
}




