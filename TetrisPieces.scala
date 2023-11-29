package ByteToTetrisPieces

object TetrisPieces extends Enumeration {

  val NONE, S, Z, T, L, L_REVERSED, SQUARE, I = Value

  // TODO Possible to have different size ?

  /*
  Get the representation of the TetrisPiece as a 2 x 4 Array of Boolean
   */
  def getRepresentation(tetrisPiece: TetrisPieces.Value): Array[Array[Boolean]] = {
    tetrisPiece match {

      /*
       Boolean representation of the NONE TetrisPiece
       Visualization:
         0 0 0 0
         0 0 0 0
      */
      case NONE => return Array(
        Array(false, false, false),
        Array(false, false, false)
      )
      /*
        Boolean representation of the S TetrisPiece
        Visualization:
           0 1 1 0
           1 1 0 0
      */
      case S => return Array(
        Array(false, true, true, false),
        Array(true, true, false, false)
      )

      /*
        Boolean representation of the Z TetrisPiece
        Visualization:
          1 1 0 0
          0 1 1 0
      */
      case Z => return Array(
        Array(true, true, false, false),
        Array(false, true, true, false)
      )

      /*
        Boolean representation of the T TetrisPiece
        Visualization:
           1 1 1 0
           0 1 0 0
         */
      case T => return Array(
        Array(true, true, true, false),
        Array(false, true, false, false)
      )

      /*
        Boolean representation of the L TetrisPiece
        Visualization:
           1 0 0 0
           1 1 1 0
       */
      case L => return Array(
        Array(true, false, false, false),
        Array(true, true, true, false)
      )

      /*
        Boolean representation of the L_REVERSED TetrisPiece
        Visualization:
           0 0 0 1
           0 1 1 1
       */
      case L_REVERSED => return Array(
        Array(false, false, false, true),
        Array(false, true, true, true)
      )

      /*
        Boolean representation of the SQUARE TetrisPiece
        Visualization:
           1 1 0 0
           1 1 0 0
       */
      case SQUARE => return Array(
        Array(true, true, false, false),
        Array(true, true, false, false)
      )

      /*
        Boolean representation of the I TetrisPiece
        Visualization:
           0 0 0 0
           1 1 1 1
       */
      case I => return Array(
        Array(false, false, false, false),
        Array(true, true, true, true)
      )
    }
  }

  /*
  Get the Byte representation of the TetrisPiece
   */
  def getByte (tetrisPieces: TetrisPieces.Value): Byte = {
    tetrisPieces match {
      case TetrisPieces.NONE        => 0.toByte
      case TetrisPieces.S           => 1.toByte
      case TetrisPieces.Z           => 2.toByte
      case TetrisPieces.T           => 3.toByte
      case TetrisPieces.L           => 4.toByte
      case TetrisPieces.L_REVERSED  => 5.toByte
      case TetrisPieces.SQUARE      => 6.toByte
      case TetrisPieces.I           => 7.toByte
    }
  }

  /*
  Get the TetrisPiece from the Byte representation
   */
  def getPieceFromByte(byte: Byte): TetrisPieces.Value = {
    val bits5to8: Byte = ((byte & 0xE0) >> 5).toByte
    println(s"bits5to8 : ${bits5to8.toBinaryString}")
    bits5to8 match {

      // 000
      case 0 => return TetrisPieces.NONE

      // 001
      case 1 => return TetrisPieces.S

      // 010
      case 2 => return TetrisPieces.Z

      // 011
      case 3 => return TetrisPieces.T

      // 100
      case 4 => return TetrisPieces.L

      // 101
      case 5 => return TetrisPieces.L_REVERSED

      // 110
      case 6 => return TetrisPieces.SQUARE

      // 111
      case 7 => return TetrisPieces.I
    }
  }

  def rotate(tetrisPiece: TetrisPieces.Value, orientation: TetrisPiecesOrientation.Value): Array[Array[Boolean]] = {
    orientation match {
      case TetrisPiecesOrientation.NORTH => return this.getRepresentation(tetrisPiece)
      case TetrisPiecesOrientation.EAST => return this.rotateEast(tetrisPiece)
      case TetrisPiecesOrientation.SOUTH => return this.rotateSouth(tetrisPiece)
      case TetrisPiecesOrientation.WEST => return this.rotateWest(tetrisPiece)
    }
  }

  /*
   Rotate the TetrisPiece to 90° (east orientation)
    */
  def rotateEast(tetrisPiece: TetrisPieces.Value): Array[Array[Boolean]] = {
    return this.getRepresentation(tetrisPiece).transpose.map(_.reverse)
  }

  /*
  Rotate the TetrisPiece to 180° (south orientation)
   */
  def rotateSouth(tetrisPiece: TetrisPieces.Value): Array[Array[Boolean]] = {
    return this.getRepresentation(tetrisPiece).transpose
  }

  /*
  Rotate the TetrisPiece to 270° to the left (west orientation)
   */
  def rotateWest(tetrisPiece: TetrisPieces.Value): Array[Array[Boolean]] = {
    return this.getRepresentation(tetrisPiece).map(_.reverse)
  }
}
