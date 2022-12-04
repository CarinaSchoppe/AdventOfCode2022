var part1 = 0
var part2 = 0
fun main() {

    object {}.javaClass.getResourceAsStream("challenge4.txt")?.bufferedReader()?.readLines()!!.forEach { line ->

        val pair = line.split(',')
        val a = pair[0].split("-").map { it.toInt() }
        val b = pair[1].split("-").map { it.toInt() }
        if (((b[0] >= a[0]).and(b[1] <= a[1])) or ((a[0] >= b[0]).and(a[1] <= b[1]))) {
            part1++
        }
    }
    println(part1)
}