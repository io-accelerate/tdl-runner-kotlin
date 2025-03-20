import io.accelerate.client.queue.abstractions.ParamAccessor
import solutions.DMO.InventoryItem
import solutions.SUM.SumSolution
import solutions.HLO.HelloSolution
import solutions.FIZ.FizzBuzzSolution
import solutions.CHK.CheckoutSolution
import solutions.DMO.*


class EntryPointMapping {
    private val sumSolution = SumSolution()
    private val helloSolution = HelloSolution()
    private val fizzBuzzSolution = FizzBuzzSolution()
    private val checkoutSolution = CheckoutSolution()
    private val demoRound1Solution = DemoRound1Solution()
    private val demoRound2Solution = DemoRound2Solution()
    private val demoRound3Solution = DemoRound3Solution()
    private val demoRound4n5Solution = DemoRound4n5Solution()

    fun sum(p: List<ParamAccessor>): Any? {
        return sumSolution.sum(p[0].asInteger, p[1].asInteger)
    }

    fun hello(p: List<ParamAccessor>): Any? {
        return helloSolution.hello(p[0].asString)
    }

    fun fizzBuzz(p: List<ParamAccessor>): Any? {
        return fizzBuzzSolution.fizzBuzz(p[0].asInteger)
    }

    fun checkout(p: List<ParamAccessor>): Any? {
        return checkoutSolution.checkout(p[0].asString)
    }

    // Demo Round 1

    fun increment(p: List<ParamAccessor>): Any? {
        return demoRound1Solution.increment(p[0].asInteger)
    }

    fun toUppercase(p: List<ParamAccessor>): Any? {
        return demoRound1Solution.toUppercase(p[0].asString)
    }

    fun letterToSanta(p: List<ParamAccessor>): Any? {
        return demoRound1Solution.letterToSanta()
    }

    fun countLines(p: List<ParamAccessor>): Any? {
        return demoRound1Solution.countLines(p[0].asString)
    }

    // Demo Round 2

    fun arraySum(p: List<ParamAccessor>): Any? {
        return demoRound2Solution.arraySum(p[0].getAsListOf(Int::class.java))
    }

    fun intRange(p: List<ParamAccessor>): Any? {
        return demoRound2Solution.intRange(p[0].asInteger, p[1].asInteger)
    }

    fun filterPass(p: List<ParamAccessor>): Any? {
        return demoRound2Solution.filterPass(p[0].getAsListOf(Int::class.java), p[1].asInteger)
    }

    // Demo Round 3

    fun inventoryAdd(p: List<ParamAccessor>): Any? {
        return demoRound3Solution.inventoryAdd(p[0].getAsObject(InventoryItem::class.java), p[1].asInteger)
    }

    fun inventorySize(p: List<ParamAccessor>): Any? {
        return demoRound3Solution.inventorySize()
    }

    fun inventoryGet(p: List<ParamAccessor>): Any? {
        return demoRound3Solution.inventoryGet(p[0].asString)
    }

    // Demo Round 4 and 5

    fun waves(p: List<ParamAccessor>): Any? {
        return demoRound4n5Solution.waves(p[0].asInteger)
    }
}
