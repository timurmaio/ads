// error
// var a: String = null

// nullable type
var b: String? = null

// return value or null
var x = b?.length

// Elvis operator: return value or right side of expression
val l = b?.length ?: -1

// return value or throw NPE
val m = b!!.length
