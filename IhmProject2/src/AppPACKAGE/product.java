package AppPACKAGE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class product {
	
	public  String url="C:\\Users\\ANNO TAC\\eclipse-workspace\\IhmProject2\\src\\AppPACKAGE\\images\\";
	private  String panelBackgroundColor ="0xD7C79E" ;
	
	
	private String productName;
	private String productType;
	private  int quantity;
	public  int price;
	
    public product(String name,String type,int Q,int price) {
    	this.productName = name;
        this.productType = type;
        this.quantity = Q;
        this.price = price;
    }
    
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    public JPanel initProductPanel() {
    	JPanel pP = new JPanel();
    	
    	pP.setPreferredSize(new Dimension(0, 180));
    	pP.setLayout(new BorderLayout());
    	//JPanel moreInfo = new JPanel();
    	//moreInfo.setLayout(new BorderLayout());
    	//JButton moreInfoButton = new JButton();
    	//moreInfo.add(moreInfoButton,BorderLayout.CENTER);
    	
    	
    	//pP.add(moreInfo,BorderLayout.SOUTH);
    	JLabel productNameLabel = new JLabel(productName);
    	productNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));
    	productNameLabel.setFont(new Font("Arial", Font.BOLD, 25));
    	pP.add(productNameLabel,BorderLayout.NORTH);
    	ImageIcon image = new ImageIcon(url+productName+".jpg");
    	image = getScaledIcon(image, 150, 150);
    	//image.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
    	JLabel productImageLabel = new JLabel(image);
    	productImageLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
    	
    	pP.add(productImageLabel,BorderLayout.WEST);
    	JPanel info = productInfo();
    	info.setBackground(Color.decode(panelBackgroundColor));
    	pP.add(info,BorderLayout.CENTER);
    	pP.add(new JLabel(" "),BorderLayout.SOUTH);
    	
    	pP.setBackground(Color.decode(panelBackgroundColor));
    	
    	
    	return pP;
    }
    
    public static ImageIcon getScaledIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
    public JPanel productInfo() {
    	JPanel info = new JPanel();
    	info.setLayout(new GridLayout(3,1));
    	
    	
    	JLabel productTypelabel = new JLabel("type :" + productType);
    	productTypelabel.setFont(new Font("Arial", Font.BOLD, 15));
    	JLabel productQuantitylabel = new JLabel("quantity :" + quantity );
    	productQuantitylabel.setFont(new Font("Arial", Font.BOLD, 15));
    	JLabel productPricelabel = new JLabel("price :" + price);
    	productPricelabel.setFont(new Font("Arial", Font.BOLD, 15));
    	
    	
    	info.add(productTypelabel);
    	info.add(productQuantitylabel);
    	info.add(productPricelabel);
    	
    	info.setBorder(BorderFactory.createEmptyBorder(10, 20,10, 10));
    	
    	return info;
    }
       
}
