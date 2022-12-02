val elfCals =
"""
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000"""

fun main(){
    val elfMap = mutableMapOf<Int,Int>()
    val elfStringItems = elfCals.split(regex = Regex.fromLiteral("\n\n"),0).map { s ->
        s.split(Regex.fromLiteral("\n")).filter { it != "" }.map{it.toInt()}.toList()
    }.toList()
    for((index,bag) in elfStringItems.withIndex()){
        var sum =0
        for (value in bag){
            sum+=value
        }
        elfMap[index+1]=sum
    }

    println(elfMap.maxBy { it.value })
    }
