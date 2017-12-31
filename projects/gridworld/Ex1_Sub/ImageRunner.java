// this is main runner file of this project
// use `ant run` to run


// we can see there is a file ImageReader.jar from lib floder
// you can open this jar file and you will find there is imagereader floder
// as you see Runner is a *.class file in it 
// import imagereader.Runner;
import imagereader.Runner;

// this is main class of image reader app
public class ImageRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NewImageIO imageIO = new NewImageIO();
		NewImageProcessor imageProcessor = new NewImageProcessor();

		Runner.run(imageIO, imageProcessor);
	}

}
