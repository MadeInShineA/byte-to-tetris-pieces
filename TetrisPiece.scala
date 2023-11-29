package ByteToTetrisPieces
import java.awt.Color

class TetrisPiece (pieceType: TetrisPiecesShapes.Value, orientation: TetrisPiecesOrientations.Value, color: Color){
  val arrayRepresentation: Array[Array[Boolean]] = getArrayRepresentation
  def getArrayRepresentation: Array[Array[Boolean]] = {
    return rotate(this.orientation)
  }
  def rotate(orientation: TetrisPiecesOrientations.Value): Array[Array[Boolean]] = {
    orientation match {
      case TetrisPiecesOrientations.NORTH => return TetrisPiecesShapes.getRepresentation(pieceType)
      case TetrisPiecesOrientations.EAST => return this.rotateEast
      case TetrisPiecesOrientations.SOUTH => return this.rotateSouth
      case TetrisPiecesOrientations.WEST => return this.rotateWest
    }
  }

  /*
   Rotate the TetrisPiece to 90° (east orientation)
    */
  def rotateEast: Array[Array[Boolean]] = {
    return TetrisPiecesShapes.getRepresentation(pieceType).transpose.map(_.reverse)
  }

  /*
  Rotate the TetrisPiece to 180° (south orientation)
   */
  def rotateSouth: Array[Array[Boolean]] = {
    return TetrisPiecesShapes.getRepresentation(pieceType).transpose
  }

  /*
  Rotate the TetrisPiece to 270° to the left (west orientation)
   */
  def rotateWest: Array[Array[Boolean]] = {
    return TetrisPiecesShapes.getRepresentation(pieceType).map(_.reverse)
  }

  override def toString: String = {
    var res: String = ""
    for (i <- arrayRepresentation.indices) {
          for (j <- arrayRepresentation(i).indices) {
            if (arrayRepresentation(i)(j)) {
              res += "X"
            } else {
              res += " "
            }
          }
          res += "\n"
        }
    return  new AnsiStringBuilder().color24(color.getRed, color.getGreen, color.getBlue).append(res).toString()

  }
}

object TetrisPiece{
  def byteToTetrisPieces(byte: Byte): TetrisPiece = {
    val tetrisPieceType: TetrisPiecesShapes.Value = TetrisPiecesShapes.getPieceShapeFromByte(byte)
    val pieceOrientation: TetrisPiecesOrientations.Value = TetrisPiecesOrientations.getOrientationFromByte(byte)
    val color: java.awt.Color = TetrisPiecesColors.getColorFromByte(byte)
    return new TetrisPiece(tetrisPieceType,pieceOrientation,color)
  }
}
