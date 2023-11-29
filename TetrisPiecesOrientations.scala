package ByteToTetrisPieces

object TetrisPiecesOrientations extends Enumeration {
  val NORTH, EAST, SOUTH, WEST = Value

  /*
  Get Byte representation of the TetrisPieceOrientation
   */
  def getByte: Byte = {
    this match {
      case NORTH  => return 0.toByte
      case EAST   => return 1.toByte
      case SOUTH  => return 2.toByte
      case WEST   => return 3.toByte
    }
  }

  def getOrientationFromByte(byte: Byte): TetrisPiecesOrientations.Value = {
    val bite3To4: Byte = ((byte & 0x18) << 3 >> 6).toByte
    bite3To4 match {

      // 00
      case 0 => return NORTH

      // 01
      case 1 => return EAST

      // 10
      case 2 => return SOUTH

      // 11
      case 3 => return WEST
    }
  }
}
