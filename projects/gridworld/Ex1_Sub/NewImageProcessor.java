// this is ImageProcessor file of this project
// just implements the request API


import imagereader.IImageProcessor;
// this time in fact we just use IImageIO
// 
import java.awt.image.*;
// for Image
import java.awt.*;

public class NewImageProcessor implements IImageProcessor
{
	public Image showChanelR(Image image)
	{
		return showWithKey(image, 0xffff0000);
	}

	public Image showChanelG(Image image)
	{
		return showWithKey(image, 0xff00ff00);
	}

	public Image showChanelB(Image image)
	{
		return showWithKey(image, 0xff0000ff);
	}

	public Image showGray(Image image)
	{
		GrayFilter filter = new GrayFilter();
		return Toolkit.getDefaultToolkit().createImage(
				new FilteredImageSource(image.getSource(),
					filter));
	}

	private Image showWithKey(Image image, int key)
	{
		KeyFilter filter = new KeyFilter(key);
		return Toolkit.getDefaultToolkit().createImage(
				new FilteredImageSource(image.getSource(),
					filter));
	}

	class KeyFilter extends RGBImageFilter
	{
		private int key;

		public KeyFilter(int num)
		{
			canFilterIndexColorModel = true;
			this.key = num;
		}

		public  int filterRGB(int x, int y, int rgb)
		{
			return (rgb & this.key);
		}
	}

	class GrayFilter extends RGBImageFilter
	{

		public GrayFilter()
		{
			canFilterIndexColorModel = true;
		}

		public  int filterRGB(int x, int y, int rgb)
		{
			int gray = (int)(
				((rgb & 0x00ff0000) >> 16 ) * 0.299 + 
				((rgb & 0x0000ff00) >>  8 ) * 0.587 + 
				((rgb & 0x000000ff) >>  0 ) * 0.114 );
			return (rgb & 0xff000000) + 
				   (gray << 16) + 
				   (gray <<  8) + 
				   (gray <<  0);
		}
	}
}