

import org.apache.commons.lang3.StringUtils


object StringReverseDemo {
    @JvmStatic
    fun main(args: Array<String>) {

        val words = "Malayalam RaceCar"

        val reversed:String = StringUtils.reverse(words)

        val delimitedReverse: String = StringUtils.reverseDelimited(words, ' ')

        // Print out the result
        println("Original: $words")
        println("Reversed: $reversed")
        println("Delimited Reverse: $delimitedReverse")
    }
}