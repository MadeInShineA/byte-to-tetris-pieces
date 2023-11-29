package ByteToTetrisPieces

object TetrisPiecesShapes extends Enumeration {

  val S, Z, T, L, L_REVERSED, SQUARE, I, FULL = Value

  def getRepresentation(tetrisPiece: TetrisPiecesShapes.Value): Array[Array[Boolean]] = {
    tetrisPiece match {

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

      /*
       Boolean representation of the FULL TetrisPiece
       Visualization:
         1 1 1 1
         1 1 1 1
      */
      case FULL => return Array(
        Array(false, false, false),
        Array(false, false, false)
      )
    }
  }

  /*
  Get the Byte representation of the TetrisPiece
   */
  def getByte (tetrisPieces: TetrisPiecesShapes.Value): Byte = {
    tetrisPieces match {
      case TetrisPiecesShapes.S           => 0.toByte
      case TetrisPiecesShapes.Z           => 1.toByte
      case TetrisPiecesShapes.T           => 2.toByte
      case TetrisPiecesShapes.L           => 3.toByte
      case TetrisPiecesShapes.L_REVERSED  => 4.toByte
      case TetrisPiecesShapes.SQUARE      => 5.toByte
      case TetrisPiecesShapes.I           => 6.toByte
      case TetrisPiecesShapes.FULL        => 7.toByte
    }
  }

  /*
  Get the TetrisPiece from the Byte representation
   */
  def getPieceShapeFromByte(byte: Byte): TetrisPiecesShapes.Value = {
    val bits5to8: Byte = ((byte & 0xE0) >> 5).toByte
    bits5to8 match {

      // 000
      case 0 => return TetrisPiecesShapes.S

      // 001
      case 1 => return TetrisPiecesShapes.Z

      // 010
      case 2 => return TetrisPiecesShapes.T

      // 011
      case 3 => return TetrisPiecesShapes.L

      // 100
      case 4 => return TetrisPiecesShapes.L_REVERSED

      // 101
      case 5 => return TetrisPiecesShapes.SQUARE

      // 110
      case 6 => return TetrisPiecesShapes.I

      // 111
      case 7 => return TetrisPiecesShapes.FULL
    }
  }
}
