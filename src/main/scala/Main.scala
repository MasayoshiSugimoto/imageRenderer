import java.awt.Color
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

object ImageRenderer {
  def main(args: Array[String]): Unit = {

    //Check the parameters
    if (args.size != 3) {
      println("Need exactly 2 parameters")
    }

    val filePath: String = args(0)
    val width: Int = args(1).toInt
    val height: Int = args(2).toInt

    val file = new File(filePath)
    if (!file.isFile()) {
      println("First parameter must be an image.")
      return
    }

    //Reading the image
    val image: BufferedImage = ImageIO.read(file)

    //Resizing the image
    val resizedImage = new BufferedImage(width, height, image.getType())
    resizedImage.getGraphics().drawImage(image, 0, 0, width, height, null)

    //Rendering the image
    (0 until height).foreach{ y =>
      (0 until width).foreach{ x =>
        val color = new Color(resizedImage.getRGB(x, y))
        print(s"\u001B[0;48;2;${color.getRed()};${color.getGreen()};${color.getBlue()}m ")
      }
    }
  }
}