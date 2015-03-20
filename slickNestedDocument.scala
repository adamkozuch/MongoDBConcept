

It will be neccesery to enforce schema to keep typesafety.


{
               _id: ObjectId("5099803df3f4948bd2f98391"),  // check how it would be with ObjectId for now simple int
               name: { first: "Alan", last: "Turing" },
               birth: new Date('Jun 23, 1912'),
               death: new Date('Jun 07, 1954'),
               contribs: [ "Turing machine", "Turing test", "Turingery" ],
               views : NumberLong(1250000)
}

class Nazwa extends Document[Int,Document,Date,Date,String*, Document](tag,nameOfCollection)
{
     //this is already implemented
     def contribs = collumn[Int]("id");
     def id = collumn[Int]("id");
     //nested document not implemented
     def name = document[String,String]("name")
     {
     def first = collumn[String]("id");
     def last = collumn[String]("id")
     }
     //teoretycznie powinno byc date
     def birth = collumn[Int]("id");
     def death = collumn[Int]("id");

     //wazne jek sobie poradzić z tablicami
     def contribs* = collumn[String]("contribs"); //tutaj trzeba oznaczyc ze moze byc wiele

     def creator= Document[ref]{
def ref
def id
def db
}

And now we define projection
def * (contribs,id,name,birth,death,contribs*,creator)

}



val nawa_query = TableQuery[Nazwa] // table query też prawdopodobnie powinna być zmodyfikowana

nazwa_query += (1,"John",123L)









//even if document would be empty it would be exist in database
//or maybe if all children are empty that's all
class Nazwa extends Document[Int,String,Document](tag,nameOfCollection)
{
def id = collumn[Int]("id");
def name = collumn[Int]("name")
def nestedDocument = Document[Int*,Int*,Int*]("adresses") //jeśli jest array to może wystarczy ten znaczek *
{
  def number1=collumn[Int]("first")
  def number2=collumn[Int]("secound")
  def number3=collumn[Int]("Third")
}

}

Document should be extension of Table


Teraz jak chciałbym coś dodać do tabeli


val nawa_query = TableQuery[Nazwa] // table query też prawdopodobnie powinna być zmodyfikowana

nazwa_query. += (1,"John",123L)
