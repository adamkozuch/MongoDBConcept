


"creator" : {
                  "$ref" : "creators",
                  "$id" : ObjectId("5099803df3f4948bd2f98391"),
                  "$db" : "users"
               }



{
               _id: ObjectId("5099803df3f4948bd2f98391"),  // check how it would be with ObjectId for now simple int
               name: { first: "Alan", last: "Turing" },
               birth: new Date('Jun 23, 1912'),
               death: new Date('Jun 07, 1954'),
               contribs: [ "Turing machine", "Turing test", "Turingery" ],
               views : NumberLong(1250000)
}





class creators extends Document[Int,Document,String*](tag,nameOfCollection)
{
     //this is already implemented
     def id:Rep[] = collumn[Int]("id");

     //nested document not implemented yet
     def name:Rep[Document] = new Document[String,String](id_of_document)
         {
             def first:Rep[String] = collumn[String]("first");
             def last:Rep[String] = collumn[String]("last")
         }

     //how to handle tables
     def contribs(*):Rep[String*] = collumn[String*]("contribs"); //star mean that this is an array

     def * =(id,(first,last),contribs*)
}

val db = Database.forURL("mongodb://localhost:27017/test")

try {

    // The query interface for the creators collection
    val creators: DocumentQuery[creator] = DocumentQuery[creator]
     val setupAction: DBIO[Unit] = DBIO.seq(
     // create the schema of document
    creators.schema.create,
    suppliers += (1, ("Thomas", "Edison"),["bulb","electricity"]),
    suppliers += ( 2, ("Nikola", "Tesla"), ["wireless lighting", "induction motor", "AC dynamo-electric machine","radio-controlled boat"]),
    suppliers += (3, ("Henry", "Ford"), ["car", "engine"])
    )

  val setupFuture: Future[Unit] = db.run(setupAction)

  // Insert some coffees (using JDBC's batch insert feature)

  val f = setupFuture.flatMap { _ =>



      val insertAction =
      creators += Seq (//
       (4, ("Socrates",None),[])  //I believe if some field has no value we should provide None
     )


  }
}












val nawa_query = TableQuery[Nazwa] // table query też prawdopodobnie powinna być zmodyfikowana

nazwa_query += (1,"John",123L)  ważne jest że jeśli wprowadzimy blędne dane tutaj to kompilator wyrzuci błąd









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
