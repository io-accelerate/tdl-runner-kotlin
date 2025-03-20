
import solutions.CHK.CheckoutSolution
import solutions.FIZ.FizzBuzzSolution
import solutions.HLO.HelloSolution
import solutions.SUM.SumSolution.sum

import com.google.gson.JsonElement

class EntryPointMapping {

    fun sum(p: List<JsonElement>): Any {
        return sum(p[0].asInt, p[1].asInt)
    }

    fun hello(p: List<JsonElement>): Any {
        return HelloSolution.hello(p[0].asString)
    }
    
    fun fizzBuzz(p: List<JsonElement>): Any {
        return FizzBuzzSolution.fizzBuzz(p[0].asInt)
    }

    fun checkout(p: List<JsonElement>): Any {
        return CheckoutSolution.checkout(p[0].asString)
    }
}
