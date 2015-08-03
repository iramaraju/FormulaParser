package com.vec.test
object funcs {

  
  val processin = (d: Double, expr :String) => { 
       import FormulaParser._ 
      val fp = new FormulaParser(
               constants = Map("@val" -> d),
               userFcts = Map()
               )
      fp.evaluate(expr)
  }  


}

/**

val formulaParser = new FormulaParser(
    constants = Map("radius" -> 8D,
                    "height" -> 10D,
                    "c" -> 299792458, // m/s
                    "v" -> 130 * 1000 / 60 / 60, // 130 km/h in m/s
                    "m" -> 80),
    userFcts  = Map("perimeter" -> { _.toDouble * 2 * Pi } ))

println(formulaParser.evaluate("2+3*5")) // 17.0
println(formulaParser.evaluate("height*perimeter(radius)")) // 502.6548245743669
println(formulaParser.evaluate("m/sqrt(1-v^2/c^2)"))  // 80.00000000003415

**/
 
