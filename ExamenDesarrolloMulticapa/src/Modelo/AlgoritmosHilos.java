package Modelo;
//import Imagen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;



public class AlgoritmosHilos extends Thread{
	
	private static final double[][] FILTER_VERTICAL = {{1, 0, -1}, {1, 0, -1}, {1, 0, -1}};
	private static final double[][] FILTER_SCHARR_V = {{3, 0, -3}, {10, 0, -10}, {3, 0, -3}};
	private static final double[][] FILTER_SOBEL_H = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
	private static final double[][] FILTER_HORIZONTAL = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};

	
	int algoritmo = 0;
	Imagen Imagen;
	BufferedImage OriImagen;
	int heigth;
	int width;
	ImageIcon icon;
	
	
	double[][] img2d;
	double[][][] img;
	File conv;
	BufferedImage imgC;
	
	public AlgoritmosHilos(int algoritmo, Imagen Img, int w_, int h_){
		this.Imagen = Img;
		this.algoritmo = algoritmo;
		this.OriImagen = Img.bimg;
		this.heigth = h_;
		this.width = w_;
	}
	
	public AlgoritmosHilos(Imagen Img, int w_, int h_){
		this.Imagen = Img;
		this.OriImagen = Img.bimg;
		this.width = w_;
		this.heigth = h_;
	}
	
	public void run() {
		if (this.algoritmo == 1) {
			this.alg1();
		}
		else if(this.algoritmo == 2) {
			this.alg2();
		}
		else if(this.algoritmo == 3) {
			this.alg3();
		}
		else {
			this.alg4();
		}
		
		
	}
	
	private double[][][] transformar() {
	    double[][][] image = new double[3][heigth][width];
	    for (int i = 0; i < heigth; i++) {
	        for (int j = 0; j < width; j++) {
	            Color color = new Color(OriImagen.getRGB(j, i));
	            image[0][i][j] = color.getRed();
	            image[1][i][j] = color.getGreen();
	            image[2][i][j] = color.getBlue();
	        }
	    }
	    return image;
	}
	
	private double[][] applyConvolution(int width, int height, double[][][] image, double[][] filter) {
	    Convolution convolution = new Convolution();
	    double[][] redConv = convolution.convolutionType2(image[0], height, width, filter, 3, 3, 1);
	    double[][] greenConv = convolution.convolutionType2(image[1], height, width, filter, 3, 3, 1);
	    double[][] blueConv = convolution.convolutionType2(image[2], height, width, filter, 3, 3, 1);
	    double[][] finalConv = new double[redConv.length][redConv[0].length];
	//sum up all convolution outputs
	    for (int i = 0; i < redConv.length; i++) {
	        for (int j = 0; j < redConv[i].length; j++) {
	            finalConv[i][j] = redConv[i][j] + greenConv[i][j] + blueConv[i][j];
	        }
	    }
	    return finalConv;
	}
	
	private File createImageFromConvolutionMatrix(BufferedImage originalImage, double[][] imageRGB) throws IOException {
	    BufferedImage writeBackImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
	    for (int i = 0; i < imageRGB.length; i++) {
	        for (int j = 0; j < imageRGB[i].length; j++) {
	            Color color = new Color(fixOutOfRangeRGBValues(imageRGB[i][j]),
	                    fixOutOfRangeRGBValues(imageRGB[i][j]),
	                    fixOutOfRangeRGBValues(imageRGB[i][j]));
	            writeBackImage.setRGB(j, i, color.getRGB());
	        }
	    }
	    File outputFile = new File("../edgesTmp"+this.algoritmo+".jpg");
	    ImageIO.write(writeBackImage, "jpg", outputFile);
	    return outputFile;
	}
	
	private int fixOutOfRangeRGBValues(double value) {
	    if (value < 0.0) {
	        value = -value;
	    }
	    if (value > 255) {
	        return 255;
	    } else {
	        return (int) value;
	    }
	}
	
	public void alg1() {
		this.img = transformar();
		this.img2d = applyConvolution(width, heigth, this.img, FILTER_VERTICAL);
		try {
			this.conv = createImageFromConvolutionMatrix(OriImagen, img2d);
			this.imgC = ImageIO.read(conv);
			this.icon = (new ImageIcon(new ImageIcon(imgC).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alg2() {
		this.img = transformar();
		this.img2d = applyConvolution(width, heigth, this.img, FILTER_HORIZONTAL);
		try {
			this.conv = createImageFromConvolutionMatrix(OriImagen, img2d);
			this.imgC = ImageIO.read(conv);
			this.icon = (new ImageIcon(new ImageIcon(imgC).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alg3() {
		this.img = transformar();
		this.img2d = applyConvolution(width, heigth, this.img, FILTER_SOBEL_H);
		try {
			this.conv = createImageFromConvolutionMatrix(OriImagen, img2d);
			this.imgC = ImageIO.read(conv);
			this.setIcon(new ImageIcon(new ImageIcon(imgC).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alg4() {
		this.img = transformar();
		this.img2d = applyConvolution(width, heigth, this.img, FILTER_SCHARR_V);
		try {
			this.conv = createImageFromConvolutionMatrix(OriImagen, img2d);
			this.imgC = ImageIO.read(conv);
			icon = (new ImageIcon(new ImageIcon(imgC).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImageIcon getIcon() {
		return this.icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
