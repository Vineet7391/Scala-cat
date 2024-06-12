package scalaCats

import java.io.{FileInputStream, FileOutputStream}
import java.nio.ByteBuffer
import scala.util.Using

trait Channel {
  def write(obj: Any): Unit
}

object FileChannel extends Channel with App {
  override def write(obj: Any): Unit = {

    val arrayOfByte: Array[Byte] = obj match {
      case n: Int =>
//        n.toByte
        val bb = ByteBuffer.allocate(4)
        bb.putInt(n)
        bb.array()
      case s: String =>
        s.getBytes
      case _ => throw new Exception("Invalid")
    }

    Using(new FileOutputStream("src/main/scala/scalaCats/test.txt")) { os =>
      os.write(arrayOfByte)
      os.flush()
    }
  }
write(8)

}
//shipra mall