package by.test.SCAND.java.bean;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileInput {


    private static String str(Class<?> cls) {
        String name = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cls.getName().replace(cls.getSimpleName(), "").replace(".", File.separator);
        return name + path;
    }

    public static void main(String[] args) {
        try {
            BufferedImage image = getBufferedImage();
            writePhoto(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static BufferedImage getBufferedImage() throws IOException {
        return ImageIO.read(
                        new FileInputStream(str(FileInput.class) + "photo.jpg"));
    }

    private static void writePhoto(BufferedImage image) throws IOException {
        ImageIO.write(image,"JPEG",new FileOutputStream(str(FileInput.class)+"newphoto.jpg"));
    }
}
