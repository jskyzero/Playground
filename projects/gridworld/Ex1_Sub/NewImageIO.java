// this is ImageIO file that implements IImageIO
// just use binary file read method wrote by ourselves
// sava to file is said to be use Java's API (smile face)


// this time in fact we just use IImageIO
import imagereader.*;
// 
import java.awt.image.*;
// for Image
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class NewImageIO implements IImageIO 
{
	// head and info total size
	public static final int READ_SIZE = 54;

	// implements READ
	public Image myRead(String filePath)
	{
		Image image;
		try
		{
			
			FileInputStream in = new FileInputStream(filePath);

			byte bytes[] = new byte[READ_SIZE];
			
			in.read(bytes, 0, READ_SIZE);

			int width = myByte2Int(bytes, 18, 22);
			int height = myByte2Int(bytes, 22, 26);
			int size = myByte2Int(bytes, 34, 38);

			int spaceSize = (size / height) - width * 3;
			spaceSize = spaceSize == 4 ? 0 : spaceSize;

			int data[] = new int[width * height];
			byte buffer[] = new byte[size];
			in.read(buffer, 0, size);

			int index = 0;
			for (int i = 0; i < height; i++)
			{
				for (int j = 0; j < width; j++)
				{
					data[width * (height - i - 1) + j] = 
					(255 & 0xff) << 24
					| (((int)buffer[index + 2] & 0xff) << 16)
					| (((int)buffer[index + 1] & 0xff) <<  8)
					| (((int)buffer[index + 0] & 0xff) <<  0);

					index += 3;
				}
				index += spaceSize;
			}


			image = Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(
					width, height, data, 0, width));

			in.close();
			return image;
		}
		catch (Exception e)
		{
			System.out.println("error");
		}
		return (Image)null;

	}

	// implements WRITE
	public Image myWrite(Image image, String filePath)
	{
		try
		{
			File imageFile = new File(filePath + ".bmp");
			BufferedImage buffer = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = buffer.createGraphics();
			g2.drawImage(image, 0, 0, null);
			g2.dispose();
			
			ImageIO.write(buffer, "bmp", imageFile);
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		return image;
	}


	// we need a method that eaily trans bytes to int 
	public int myByte2Int(byte bytes[], int begin, int end) 
	{
		// we store LSB in higher index
		int ans = 0;
		// E.G byte[] = {1, 2, 3, 4}  ans    = 0x04030201
		for (int i = begin; i < end; i++)
		{
			ans += (int)(bytes[i] & 0xff) << (8 * (i - begin));
		}

		return ans;
	}
}