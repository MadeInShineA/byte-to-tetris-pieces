package ByteToTetrisPieces
import java.awt.Color

object TetrisPiecesColor {
  private val COLORS: Array[Color] = Array(
    new Color(0, 0, 0),
    new Color(0, 0, 255),
    new Color(0, 255, 0),
    new Color(0, 255, 255),
    new Color(255, 0, 0),
    new Color(255, 0, 255),
    new Color(255, 255, 0),
    new Color(255, 255, 255)
  )
  def getColorFromByte(byte: Byte): Color = {
    val bite0To3: Byte = (byte & 0xF8).toByte
    COLORS(bite0To3)
  }
}
