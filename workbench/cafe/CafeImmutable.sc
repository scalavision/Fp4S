
case class Coffee(price: Double = 5)

case class CreditCard() {
  def charge(amount: Double): Unit = {
    println("charging: " + amount)
    // connecting to the creditcard company
  }
}

case class Charge(
  creditCard: CreditCard, 
  amount: Double
) {
  def combine(other: Charge): Charge = 
    if (creditCard == other.creditCard) 
      Charge(creditCard, other.amount + amount)
    else
      throw new Exception("Credit cards needs to be the same")
}

case object Cafe {

  def buyCoffee(creditCard: CreditCard): (Coffee, Charge) = {
    val cup = Coffee()
    (cup, Charge(creditCard, cup.price))
  }

  def buyCoffees(nrOfCoffees: Int, creditCard: CreditCard): (List[Coffee], Charge) = {
    val purchases = List.fill(nrOfCoffees)(buyCoffee(creditCard))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce( (c1, c2) => c1.combine(c2)))
  }

}

val (coffee, bill) = 
  Cafe.buyCoffee(CreditCard())

println("bought 1 cup of coffee")
// Here we run the program
bill.creditCard.charge(bill.amount)

val (coffees, bill2) = 
  Cafe.buyCoffees(5, CreditCard())

println("buying 5 cups of coffee")
// Here we run the program
bill2.creditCard.charge(bill2.amount)
