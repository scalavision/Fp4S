
case class Coffee(price: Double = 4.22)

case class CreditCard() {
  def charge(amount: Double): Unit = {
    // connecting to the creditcard company
  }
}

case object Cafe {
  def buyCoffee(creditCard: CreditCard): Coffee = {
    val cup = Coffee()

    creditCard.charge(cup.price)

    cup
  
  }
}

pprint.pprintln(
  Cafe.buyCoffee(CreditCard())
)

