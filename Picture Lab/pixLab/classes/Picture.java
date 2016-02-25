import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
         toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }


  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel currPixel = null;
    Pixel rightPixel = null;
    Color rightColor = null;
    Pixel bottomPixel = null;
    Color bottomColor = null;

    for (int row = 0; row < pixels.length - 1; row++) {
        for (int col = 0; col < pixels[0].length - 1; col++) {
            currPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            rightColor = rightPixel.getColor();
            bottomPixel = pixels[row + 1][col];
            bottomColor = bottomPixel.getColor();

            if (currPixel.colorDistance(rightColor)  > edgeDist ||
                currPixel.colorDistance(bottomColor) > edgeDist)
                    currPixel.setColor(Color.BLACK);
            else
                currPixel.setColor(Color.WHITE);
        }
    }
  }

  ////////////////// Start of Lab Code ////////////////////

  public void keepOnlyBlue() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] row : pixels) {
          for (Pixel pixelObj : row) {
              pixelObj.setRed(0);
              pixelObj.setGreen(0);
          }
      }
  }

  public void negate() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] row : pixels) {
          for (Pixel pixelObj : row) {
              pixelObj.setRed( 255 - pixelObj.getRed() );
              pixelObj.setGreen( 255 - pixelObj.getGreen() );
              pixelObj.setBlue( 255 - pixelObj.getBlue() );
          }
      }
  }

  public void grayscale() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] row : pixels) {
          for (Pixel pixelObj : row) {
              int average = (pixelObj.getRed() +
                             pixelObj.getGreen() +
                             pixelObj.getBlue() ) / 3;
              pixelObj.setRed(average);
              pixelObj.setGreen(average);
              pixelObj.setBlue(average);
          }
      }
  }

  public void fixUnderwater() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] row : pixels) {
          for (Pixel pixelObj : row) {
              if (pixelObj.getBlue() > 160 && pixelObj.getRed() < 30) {
                  pixelObj.setBlue( (int) (pixelObj.getBlue() * 1.25) );

              }
          }
      }
  }

  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < width / 2 ; col++) {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            leftPixel.setColor(rightPixel.getColor());
        }
    }
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < width; col++) {
            topPixel = pixels[row][col];
            bottomPixel = pixels[pixels.length - 1 - row][col];
            bottomPixel.setColor(topPixel.getColor());
        }
    }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < width; col++) {
            topPixel = pixels[row][col];
            bottomPixel = pixels[pixels.length - 1 - row][col];
            topPixel.setColor(bottomPixel.getColor());
        }
    }
  }

  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel originalPixel = null;
    Pixel copyPixel = null;
    int height = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < row; col++) {
            originalPixel = pixels[row][col];
            copyPixel = pixels[col][row];
            copyPixel.setColor(originalPixel.getColor());
        }
    }
  }

  public void mirrorArms() {
    int ltb = 156, lbb = 194;
    int llb = 101, lrb = 172;
    int rtb = 172, rbb = 197;
    int rlb = 237, rrb = 295;
    Pixel originalPixel = null;
    Pixel copyPixel = null;

    Pixel[][] pixels = this.getPixels2D();
    // Copy left arm slightly below the original
    for (int row = ltb; row < lbb; row++) {
        for (int col = llb; col < lrb; col++) {
            originalPixel = pixels[row][col];
            copyPixel = pixels[row + lbb - ltb - 5][col];
            copyPixel.setColor(originalPixel.getColor());
        }
    }
    // Copy right arm slightly below original
    for (int row = rtb; row < rbb; row++) {
        for (int col = rlb; col < rrb; col++) {
            originalPixel = pixels[row][col];
            copyPixel = pixels[row + rbb - rtb][col];
            copyPixel.setColor(originalPixel.getColor());
        }
    }
  }

  public void mirrorGull() {
    int topbound = 233, botbound = 326;
    int leftbound = 237, rightbound = 350;
    Pixel originalPixel = null;
    Pixel copyPixel = null;

    Pixel[][] pixels = this.getPixels2D();
    for (int row = topbound; row < botbound; row++) {
        for (int col = leftbound; col < rightbound; col++) {
            originalPixel = pixels[row][col];
            copyPixel = pixels[row][col + rightbound - leftbound];
            copyPixel.setColor(originalPixel.getColor());
        }
    }
  }

  public void  copy(Picture inPic, int startRow, int endRow, int startCol, int endCol) {
    Pixel originalPixel = null;
    Pixel copyPixel = null;

    Pixel[][] originalPic = this.getPixels2D();
    Pixel[][] copyPic = inPic.getPixels2D();

    // Go through all the rows checking there is are enough rows to copy onto originalPic
    for (int row = startRow;
         row < endRow &&
         row < originalPic.length + startRow;
         row++) {

        // Go through all the columns checking there are enough columns to copy onto originalPic
        for (int col = startCol;
             col < endCol &&
             col < originalPic[0].length;
             col++) {

                // Swap the pixels in originalPic with those in copyPic
                // keeping the pixels in the same place
                copyPixel = copyPic[row][col];
                originalPixel = originalPic[row][col];
                originalPixel.setColor(copyPixel.getColor());
        }
    }
  }

  public void  copy(Picture inPic, int startRow, int endRow, int startCol, int endCol, int posRow, int posCol) {
    Pixel originalPixel = null;
    Pixel copyPixel = null;

    Pixel[][] originalPic = this.getPixels2D();
    Pixel[][] copyPic = inPic.getPixels2D();

    // Go through all the rows checking there is are enough rows to copy onto originalPic
    for (int row = startRow;
         row < endRow &&
         row < originalPic.length + startRow;
         row++) {

        // Go through all the columns checking there are enough columns to copy onto originalPic
        for (int col = startCol;
             col < endCol &&
             col < originalPic[0].length;
             col++) {

                // Swap the pixels in originalPic with those in copyPic
                // keeping the pixels in the same place
                copyPixel = copyPic[row][col];
                originalPixel = originalPic[posRow + row - startRow][posCol + col - startCol];
                originalPixel.setColor(copyPixel.getColor());
        }
    }
  }


  public void myCollage() {
    Picture flower = new Picture("whiteFlower.jpg");
    Picture gull   = new Picture("seagull.jpg");
    Picture akhil  = new Picture("akhil.jpg");

    gull.edgeDetection(30);
    this.copy(gull, 233, 326, 237, 350, 20, 110);

    Picture resizedAkhil = new Picture(akhil.scale(.4, .4));
    resizedAkhil.grayscale();
    this.copy(resizedAkhil, 63, 360, 156, 438, 112, 30);

    double rf = .35;
    Picture resizedFlower = new Picture(flower.scale(rf, rf));
    resizedFlower.zeroBlue();
    this.copy(resizedFlower, (int) (100 * rf), (int) (269 * rf), (int) (281 * rf), (int) (444 * rf), 110, 93);

    this.mirrorVertical();
  }
  
   public void edgeDetection2(int edgeDist) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel currPixel = null;
    Pixel rightPixel = null;
    Color rightColor = null;
    Pixel bottomPixel = null;
    Color bottomColor = null;
    
    this.keepOnlyBlue();

    for (int row = 0; row < pixels.length - 1; row++) {
        for (int col = 0; col < pixels[0].length - 1; col++) {
            currPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            rightColor = rightPixel.getColor();
            bottomPixel = pixels[row + 1][col];
            bottomColor = bottomPixel.getColor();

            if (currPixel.colorDistance(rightColor)  > edgeDist ||
                currPixel.colorDistance(bottomColor) > edgeDist)
                    currPixel.setColor(Color.BLACK);
            else
                currPixel.setColor(Color.WHITE);
        }
    }
  }

  /* Main method for testing - each class in Java can have a main
   * method
   */
  public static void main(String[] args)
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

} // this is the end of class Picture, put all new methods before this
