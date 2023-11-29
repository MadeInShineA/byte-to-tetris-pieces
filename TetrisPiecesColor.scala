package ByteToTetrisPieces
import java.awt.Color

object TetrisPiecesColor {
  def getColorFromByte(byte: Byte): Color = {
    val bite0To3: Byte = (byte & 0x07).toByte
    bite0To3 match {
      case 0 => return new Color(0, 0, 0)

      // 001
      case 1 => return new Color(0, 0, 255)

      // 010
      case 2 => return new Color(0, 255, 0)

      // 011
      case 3 => return new Color(0, 255, 255)

      // 100
      case 4 => return new Color(255, 0, 0)

      // 101
      case 5 => return new Color(255, 0, 255)

      // 110
      case 6 => return new Color(255, 255, 0)

      // 111
      case 7 => return new Color(255, 255, 255)
    }
  }

}
