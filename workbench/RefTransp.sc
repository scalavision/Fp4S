
// Functions are values
// They can be assigned to variables, 
// stored in datastructures and passed as arguments

def fib(n: Int): Int = {
  def go(step: Int, prev1: Int, prev2: Int): Int = {
    if (step == 0)
      prev1
    else
      go(step - 1, prev2, prev1 + prev2)
  }
  
  go(n, 0, 1)
}

println((0 to 5).map(fib))
