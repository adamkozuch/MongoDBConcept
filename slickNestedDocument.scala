
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global


object HelloMongo extends App {

//basicaly we build schema of document and in case that particular insstance of
//document do not have particular column or document we deliver in taht place None
class creators extends Document[Int,Document[String,String],String*](tag,nameOfCollection)
{
     //this is already implemented
     def id:Rep[] = collumn[Int]("id");

     //nested document
     //not sure about result type for now packed with Rep probably this will look different
     def name:Rep[Document] = new Document[String,String](id_of_document)
         {
             def first:Rep[String] = collumn[String]("first");
             def last:Rep[String] = collumn[String]("last")
         }

     //I have to rethink it because I'm not sure how to make a projection
     //to such a type. Maybe just provide implementation like with normal
     //document
     def reference = new DocumentRef("collection",399393993,"database" )


     //how to handle arrays
     def contribs(*):Rep[String*] = collumn[String*]("contribs"); //star mean that this is an array

     def * =(id,name->(first,last),contribs*)
}

val db = Database.forURL("mongodb://localhost:27017/test")

try {

    // The query interface for the creators collection
    val creators: DocumentQuery[creator] = DocumentQuery[creator]
     val setupAction: DBIO[Unit] = DBIO.seq(
     // create the schema of document
    creators.schema.create,
    suppliers += (1, ("Thomas", "Edison"),("coll",33333,"database"),["bulb","electricity"]),
    suppliers += ( 2, ("Nikola", "Tesla"),("coll",33333,"database"), ["wireless lighting", "induction motor", "AC dynamo-electric machine","radio-controlled boat"]),
    suppliers += (3, ("Henry", "Ford"),None, ["car", "engine"])//if I add None I can skip reference
    )

  val setupFuture: Future[Unit] = db.run(setupAction)

  // Insert some coffees (using JDBC's batch insert feature)

  val f = setupFuture.flatMap { _ =>

      val insertAction =
      creators += Seq (//
       (4, ("Socrates",None),[])  //I believe if some field has no value we should provide None
     )
  }

  val filterQuery = creators.filter(_.name.first == "Nikola")// we would use dot notation to get nested value

}
}
