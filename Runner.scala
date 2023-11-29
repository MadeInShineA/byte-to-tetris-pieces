package ByteToTetrisPieces
import hevs.graphics.FunGraphics

object Runner extends App{
  val display: FunGraphics = new FunGraphics(300, 300)

  def byteToTetrisPiece(byte: Byte): TetrisPiece = {

    // Get the information from the byte
    val tetrisPieceType: TetrisPiecesTypes.Value = TetrisPiecesTypes.getPieceFromByte(byte)
    val pieceOrientation: TetrisPiecesOrientation.Value = TetrisPiecesOrientation.getOrientationFromByte(byte)
    val color: java.awt.Color = TetrisPiecesColor.getColorFromByte(byte)
    val tetrisPiece = new TetrisPiece(tetrisPieceType,pieceOrientation,color)
    return tetrisPiece
  }
}
