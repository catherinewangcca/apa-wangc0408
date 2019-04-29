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

//below are methods that I added
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.onlyBlue();
    beach.explore();
  }

  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale()
  {
    Picture arch = new Picture("arch.jpg");
    arch.explore();
    arch.grayscale();
    arch.explore();
  }

  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.underwater();
    water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }


  public static void testMirrorHorizontalBottomToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomToTop();
    caterpillar.explore();
  }

  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }

  public static void testCopy()
  {
    Picture swan = new Picture("swan.jpg");
    Picture snowman = new Picture("snowman.jpg");
    swan.copy(snowman, 10, 10, 0, 0, 50, 50);
    swan.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg"); 
    canvas.createCollage();
    canvas.explore();
  }
  public static void myCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture barbaraS = new Picture("barbaraS.jpg");
    Picture snowman = new Picture("snowman.jpg");
    Picture swan = new Picture("swan.jpg");
    Picture kitten2 = new Picture("kitten2.jpg");
    Picture seagull = new Picture("seagull.jpg");

    barbaraS.grayscale();
    canvas.copy(barbaraS, 0, 0, 12, 12, 110, 90);

    barbaraS.negate();
    canvas.copy(barbaraS, 0, 90, 12, 12, 110, 90);

    kitten2.mirrorVertical();
    canvas.copy(kitten2, 200, 0, 83, 136, 200, 400);

    kitten2.onlyBlue();
    canvas.copy(kitten2, 200, 200, 83, 136, 240, 240);
  
    canvas.explore();
  }


  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testBlur()
  {

    Picture butterfly1 = new Picture("butterfly1.jpg");
    butterfly1.blur(300, 300, 50, 90, 10);

    butterfly1.explore();
    
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
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBottomToTop();
    //testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testCollage();
    //myCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);

    testBlur();
  }
}