package ByteToTetrisPieces
import hevs.graphics.FunGraphics

object Runner extends App{
  val display: FunGraphics = new FunGraphics(300, 300)

  def byteToTetrisPiece(byte: Byte): Unit = {

    // Get the information from the byte
    val tetrisPiece: TetrisPieces.Value = TetrisPieces.getPieceFromByte(byte)
    val pieceOrientation: TetrisPiecesOrientation.Value = TetrisPiecesOrientation.getOrientationFromByte(byte)
    val color: java.awt.Color = TetrisPiecesColor.getColorFromByte(byte)
    val rotatedTetrisPiece: Array[Array[Boolean]] = TetrisPieces.rotate(tetrisPiece,pieceOrientation)

    println(s"Couleur : ${color.toString}")
    for(i: Int <- rotatedTetrisPiece.indices){
      println(rotatedTetrisPiece(i).mkString(" "))
    }
  }

  def tetrisPieceToConsole(tetrisPiece: Array[Array[Boolean]]): Unit = {
    for(i: Int <- tetrisPiece.indices){
      println(tetrisPiece(i).mkString(" "))
    }
  }
  for(i: Int <- 0 to 255){
    println(s"Byte : ${i.toBinaryString}")
    byteToTetrisPiece(i.toByte)
  }
}
