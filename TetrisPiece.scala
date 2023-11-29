package ByteToTetrisPieces
import java.awt.Color

class TetrisPiece (pieceType: TetrisPiecesTypes.Value, orientation: TetrisPiecesOrientation.Value, color: Color){
  val arrayRepresentation: Array[Array[Boolean]] = getArrayRepresentation
  def getArrayRepresentation: Array[Array[Boolean]] = {
    return rotate(this.orientation)
  }
  def rotate(orientation: TetrisPiecesOrientation.Value): Array[Array[Boolean]] = {
    orientation match {
      case TetrisPiecesOrientation.NORTH => return TetrisPiecesTypes.getRepresentation(pieceType)
      case TetrisPiecesOrientation.EAST => return this.rotateEast
      case TetrisPiecesOrientation.SOUTH => return this.rotateSouth
      case TetrisPiecesOrientation.WEST => return this.rotateWest
    }
  }

  /*
   Rotate the TetrisPiece to 90° (east orientation)
    */
  def rotateEast: Array[Array[Boolean]] = {
    return TetrisPiecesTypes.getRepresentation(pieceType).transpose.map(_.reverse)
  }

  /*
  Rotate the TetrisPiece to 180° (south orientation)
   */
  def rotateSouth: Array[Array[Boolean]] = {
    return TetrisPiecesTypes.getRepresentation(pieceType).transpose
  }

  /*
  Rotate the TetrisPiece to 270° to the left (west orientation)
   */
  def rotateWest: Array[Array[Boolean]] = {
    return TetrisPiecesTypes.getRepresentation(pieceType).map(_.reverse)
  }
}
