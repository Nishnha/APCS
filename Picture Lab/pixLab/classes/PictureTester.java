/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  ////////////////////// Start of Lab Code //////////////////////////

  public static void testKeepOnlyBlue() {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
  }

  public static void testNegate() {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.negate();
      beach.explore();
  }

  public static void testGrayscale() {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.grayscale();
      beach.explore();
  }

  public static void testFixUnderwater() {
      Picture water = new Picture("water.jpg");
      water.explore();
      water.fixUnderwater();
      water.explore();
  }

  public static void testMirrorVerticalRightToLeft() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }

  public static void testMirrorHorizontal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBotToTop();
    beach.explore();
  }

 public static void testMirrorDiagonal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }

 public static void testMirrorArms() {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
 }

 public static void testMirrorGull() {
    Picture snowman = new Picture("seagull.jpg");
    snowman.explore();
    snowman.mirrorGull();
    snowman.explore();
 }

 public static void testCopy() {
    Picture seagull = new Picture("seagull.jpg");
    Picture flower = new Picture("whiteFlower.jpg");
    seagull.explore();
    seagull.copy(flower, 100, 444, 164, 555);
    seagull.explore();
 }

 public static void testMyCollage() {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    //canvas.explore();
    canvas.show();
 }
 
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection2(10);
    swan.explore();
  }


  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorDiagonal();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testCollage();
    //testCopy();
    //testMyCollage();
    //testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
