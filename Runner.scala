package ByteToTetrisPieces
import hevs.graphics.FunGraphics

object Runner extends App{
  val display: FunGraphics = new FunGraphics(300, 300)


  def byteToTetrisPiece(byte: Byte): Unit = {

    // Get the information from the byte
    val tetrisPiece: TetrisPieces.Value = TetrisPieces.getPieceFromByte(byte)
    val pieceOrientation: TetrisPiecesOrientation.Value = TetrisPiecesOrientation.getOrientationFromByte(byte)
    val color: java.awt.Color = TetrisPiecesColor.getColorFromByte(byte)

    val rotatedTetrisPiece: Array[Array[Boolean]] = tetrisPiece.rotate(pieceOrientation)

    // Display the TetrisPiece
  }
}
