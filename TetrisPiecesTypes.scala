package ByteToTetrisPieces

object TetrisPiecesTypes extends Enumeration {

  val NONE, S, Z, T, L, L_REVERSED, SQUARE, I = Value

  def getRepresentation(tetrisPiece: TetrisPiecesTypes.Value): Array[Array[Boolean]] = {
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
  def getByte (tetrisPieces: TetrisPiecesTypes.Value): Byte = {
    tetrisPieces match {
      case TetrisPiecesTypes.NONE        => 0.toByte
      case TetrisPiecesTypes.S           => 1.toByte
      case TetrisPiecesTypes.Z           => 2.toByte
      case TetrisPiecesTypes.T           => 3.toByte
      case TetrisPiecesTypes.L           => 4.toByte
      case TetrisPiecesTypes.L_REVERSED  => 5.toByte
      case TetrisPiecesTypes.SQUARE      => 6.toByte
      case TetrisPiecesTypes.I           => 7.toByte
    }
  }

  /*
  Get the TetrisPiece from the Byte representation
   */
  def getPieceFromByte(byte: Byte): TetrisPiecesTypes.Value = {
    val bits5to8: Byte = ((byte & 0xE0) >> 5).toByte
    println(s"bits5to8 : ${bits5to8.toBinaryString}")
    bits5to8 match {

      // 000
      case 0 => return TetrisPiecesTypes.NONE

      // 001
      case 1 => return TetrisPiecesTypes.S

      // 010
      case 2 => return TetrisPiecesTypes.Z

      // 011
      case 3 => return TetrisPiecesTypes.T

      // 100
      case 4 => return TetrisPiecesTypes.L

      // 101
      case 5 => return TetrisPiecesTypes.L_REVERSED

      // 110
      case 6 => return TetrisPiecesTypes.SQUARE

      // 111
      case 7 => return TetrisPiecesTypes.I
    }
  }
}
