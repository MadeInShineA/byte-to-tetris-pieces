package ByteToTetrisPieces

object Runner extends App{

  val s1: String = "Coucou Olive"
  val s1Bytes = s1.getBytes
  for (b: Byte <- s1Bytes) {
    println(TetrisPiece.byteToTetrisPieces(b))
  }
}
