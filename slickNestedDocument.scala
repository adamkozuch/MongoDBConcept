







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
