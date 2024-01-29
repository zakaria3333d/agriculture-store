package AppPACKAGE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class mainApp {
	
	public static product[] inCartProductsList = new product[10];
	public static boolean searchBy = true;  
	public static int cartIndex = 0; 
	public static String UserFullName ;
	public static String UserAdress ;
	
	public static String url="C:\\Users\\ANNO TAC\\eclipse-workspace\\IhmProject2\\src\\AppPACKAGE\\images\\";
	
	
	public static String menuBackgroundColor ="0x233714" ;
	public static String productsBackgroundColor ="0xFEFAE0" ;
	public static String panelBackgroundColor ="0xD7C79E" ;
	public static String logoColor ="0xD7C79E" ;
	public static String exitColor ="0xD0342C" ;
	
	public static JFrame homeFrame = initFrame("agriculture product selling app",1100,600);
	
	public static product[] productList = 
			{
					new product("tomato","vegetables",10,100),
					new product("apples","fruits",10,250),
					new product("cabbage","vegetables",10,200),
					new product("honey","Sweetener",10,3400),
					new product("oliveOil","Edible Oil",10,3100),
					new product("rice","Staple Grain",50,1000),
					new product("wheat","Staple Grain",50,1200),
					new product("bellPepper", "vegetables", 6, 180),
			        new product("grapes", "fruits", 15, 350),
			        new product("cauliflower", "vegetables", 12, 200),
			        new product("mapleHoney", "Sweetener", 8, 3200),
			        new product("sunflowerOil", "Edible Oil", 7, 2500),
			        new product("millet", "Staple Grain", 22, 700),
			        new product("rye", "Staple Grain", 20, 900),
			        new product("blueberries", "fruits", 10, 220),
			        new product("kale", "vegetables", 5, 100),
			        new product("walnuts", "Nuts", 30, 2200),
			        new product("peas", "vegetables", 9, 120),
			        new product("pineapple", "fruits", 18, 280),
			        new product("sweetPotato", "vegetables", 10, 150),
			        new product("agaveSyrup", "Sweetener", 6, 3000),
			        new product("avocadoOil", "Edible Oil", 9, 2600),
			        new product("oats", "Staple Grain", 25, 850),
			        new product("buckwheat", "Staple Grain", 20, 1000),
			        new product("cranberries", "fruits", 12, 180),
			        new product("cucumber", "vegetables", 4, 90),
			        new product("cashews", "Nuts", 28, 2400),
			        
			};

	public static void main(String[] args) {
		JFrame regestrationFrame = initFrame("regestration",900,500);
		regestrationFrame.add(createRegistrationForm(regestrationFrame)); 
		regestrationFrame.setVisible(true);
		
	}
	
	private static JFrame initFrame(String title,int width, int height) {
		JFrame f = new JFrame(title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(width, height);
        f.setLocationRelativeTo(null);
        f.setVisible(false);
		
        return f;
	}

	private static JPanel createRegistrationForm(JFrame regestrationFrame) {

		JPanel registerPanel = new JPanel();
		registerPanel.setLayout(new GridLayout(1,2));
		
		JPanel registerPanelInputs = new JPanel();
		JPanel registerPanelImage = new JPanel();
		
		//working on registerPanelImage
		
		ImageIcon image = new ImageIcon(url+"registerImage.jpg");
		JLabel imageLabel = new JLabel(image);
		
	
		registerPanelImage.setLayout(new GridLayout(1,1));
		registerPanelImage.add(imageLabel);
		registerPanelImage.setBackground(Color.decode(logoColor));
		
		//working on registerPanelInputs
        
		registerPanelInputs.setLayout(new BoxLayout(registerPanelInputs,BoxLayout.Y_AXIS));
		
			JLabel FormFullName = new JLabel("Full name");
			FormFullName.setFont(new Font("Arial", Font.BOLD, 28));
			FormFullName.setForeground(Color.decode(logoColor));
		        
			JLabel FormAdress = new JLabel("Adress ");
			FormAdress.setFont(new Font("Arial", Font.BOLD, 28));
			FormAdress.setForeground(Color.decode(logoColor));
			
			JTextField FormInputFullName = new JTextField(20);
			JTextField FormInputAdress = new JTextField(20);
			
			
			JCheckBox checkBox = new JCheckBox("i've read all the term of use .");
			checkBox.setBackground(Color.decode(menuBackgroundColor));
			checkBox.setForeground(Color.decode(logoColor));
			
			JButton regiterButton= new JButton("register");
			regiterButton.setBackground(Color.decode(logoColor));
			
			registerPanelInputs.add(FormFullName);
			registerPanelInputs.add(FormInputFullName);
			registerPanelInputs.add(FormAdress);
			registerPanelInputs.add(FormInputAdress);
			registerPanelInputs.add(checkBox);
			registerPanelInputs.add(regiterButton);
			
			registerPanelInputs.setBackground(Color.decode(menuBackgroundColor));
			
			
		
			registerPanel.add(registerPanelInputs);
			registerPanel.add(registerPanelImage);
			
			regestrationFrame.add(registerPanel,BorderLayout.CENTER);
			
			
			
			regiterButton.addActionListener(e -> {
		            
		            if(FormInputFullName.getText().equals("") ||FormInputAdress.getText().equals("") ||checkBox.isSelected() == false) {
		            	
		            }else {
		            	
		            	UserFullName = FormInputFullName.getText();
		            	UserAdress =FormInputAdress.getText() ;
		            	
		            	regestrationFrame.dispose();
		            	//homeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		            	homeFrame.setResizable(false);
		    			JPanel sideMenu = createSidebarMenuPanel(productList);
		    			homeFrame.add(sideMenu, BorderLayout.WEST);
		    	
		    	        // Add a main content panel to the center
		    			
		    			JScrollPane mainContent = createMainContentPanel(productList);
		    			homeFrame.add(mainContent, BorderLayout.CENTER);
		    		
		    	        homeFrame.setVisible(true);
		            	
		            }
		        });
		
			
			registerPanelInputs.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 60));
			
			JLabel logoLabel = new JLabel("        aGri  "); 
			logoLabel.setFont(new Font("Georgia", Font.BOLD, 25));
			logoLabel.setForeground(Color.decode(logoColor));
			
			
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 30)));// Add some spacing
			registerPanelInputs.add(logoLabel);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 30)));
			registerPanelInputs.add(FormFullName);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 10)));
			registerPanelInputs.add(FormInputFullName);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 60))); 
			registerPanelInputs.add(FormAdress);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 10))); 
			registerPanelInputs.add(FormInputAdress);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 30)));
			registerPanelInputs.add(checkBox);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 30)));
			registerPanelInputs.add(regiterButton);
			registerPanelInputs.add(Box.createRigidArea(new Dimension(0, 80)));
			
		
		return registerPanel;
	}
	
	private static JPanel createSidebarMenuPanel(product []productList) {
        JPanel sidebarMenuPanel = new JPanel();
        sidebarMenuPanel.setLayout(new BoxLayout(sidebarMenuPanel, BoxLayout.Y_AXIS));
        sidebarMenuPanel.setSize(400,400);

        // Create buttons for the menu items
        JButton logoButton = createSidebarButton("  aGri  ");
        JButton HistoryButton = createSidebarButton("History");
        JButton CartButton = createSidebarButton("Cart");
        JButton searchButton = createSidebarButton("Search");
        
        JPanel text = new JPanel();
        JTextField textInput= new JTextField(15);
        text.add(textInput);
        text.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        text.setBackground(Color.decode(menuBackgroundColor));
        
        // Create radio buttons for searching by name or category
        JRadioButton searchByNameButton = new JRadioButton("Name");
        JRadioButton searchByCategoryButton = new JRadioButton("Category");
      
        searchByNameButton.setBackground(Color.decode(menuBackgroundColor));
        searchByNameButton.setForeground(Color.white);
        searchByCategoryButton.setBackground(Color.decode(menuBackgroundColor));
        searchByCategoryButton.setForeground(Color.white);

        // Group the radio buttons ( so only one can be selected at a time )
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(searchByNameButton);
        radioButtonGroup.add(searchByCategoryButton);

        JPanel radioButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioButtonsPanel.setBackground(Color.decode(menuBackgroundColor));
        // Add radio buttons to the panel
        radioButtonsPanel.add(searchByNameButton);
        radioButtonsPanel.add(searchByCategoryButton);
       
        // Add action listeners for the radio buttons
        searchByNameButton.addActionListener(e -> {
            searchBy= true;
        });

        searchByCategoryButton.addActionListener(e -> {
            searchBy = false;
        });

        
        
        JButton exitButton = createSidebarButton("Exit");
        
        
        logoButton.setFont(new Font("Georgia", Font.BOLD, 40));
        logoButton.setForeground(Color.decode(logoColor));
        
        HistoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        CartButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        searchButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setForeground(Color.decode(exitColor));
        
        
        // Add action listeners for the buttons
        
        
        logoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	relaodPage(productList);
            }
        });
        
    
        CartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	displayInCartProducts();
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if( textInput.getText() != null ) {   
            		serchForProduct(textInput.getText(),searchBy,productList);
            	}
               
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        
        // Add buttons to the side menu panel
        sidebarMenuPanel.add(Box.createRigidArea(new Dimension(40, 50))); // Add some spacing
        sidebarMenuPanel.add(logoButton);
        sidebarMenuPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        sidebarMenuPanel.add(text);
        sidebarMenuPanel.add(radioButtonsPanel);
        sidebarMenuPanel.add(searchButton);
        sidebarMenuPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        sidebarMenuPanel.add(CartButton);
        sidebarMenuPanel.add(Box.createRigidArea(new Dimension(0, 80))); 
        sidebarMenuPanel.add(exitButton);
        sidebarMenuPanel.add(Box.createRigidArea(new Dimension(0, 110)));
        
        sidebarMenuPanel.setBackground(Color.decode(menuBackgroundColor));

        return sidebarMenuPanel;
    }

    private static JButton createSidebarButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setForeground(Color.white);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private static JScrollPane createMainContentPanel(product []productList) {
        JPanel MainContentPanel = new JPanel();
        MainContentPanel.setLayout(new GridLayout(0,2,20,20));
        JPanel marginPanel = new JPanel(new BorderLayout());
        
        MainContentPanel.setBackground(Color.decode(productsBackgroundColor));
        JScrollPane scrolMainPanel = new JScrollPane(marginPanel);
      
        
        scrolMainPanel.setBackground(Color.decode(productsBackgroundColor));
        
        MainContentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        marginPanel.add(MainContentPanel);
        
        
        for(int i=0;i<productList.length;i++) {
        	
        	if (productList[i] != null) {
	        	
	        	JPanel myProductPanel = new JPanel();
	        	myProductPanel = productList[i].initProductPanel();
	        	MainContentPanel.add(myProductPanel);
	        	myProductPanel = createClickablePanel(myProductPanel,productList[i]);
        	}

        }
        
        if(productList[2]==null ) {
        	JPanel emptyProduct1 = new JPanel();
        	emptyProduct1.setPreferredSize(new Dimension(0, 200));
        	emptyProduct1.setLayout(new GridLayout(1,1));
        	JLabel empty1 = new JLabel(" ");
        	emptyProduct1.add(empty1);
        	emptyProduct1.setBackground(Color.decode(productsBackgroundColor)); 
        
        	
        	JPanel emptyProduct2 = new JPanel();
        	emptyProduct2.setPreferredSize(new Dimension(0, 200));
        	emptyProduct2.setLayout(new GridLayout(1,1));
        	JLabel empty2 = new JLabel(" ");
        	emptyProduct2.add(empty2);
        	emptyProduct2.setBackground(Color.decode(productsBackgroundColor)); 
        	
        	MainContentPanel.add(emptyProduct1);
        	MainContentPanel.add(emptyProduct2);
        	
        	
        }

        
        return scrolMainPanel;
    }
    
    private static JPanel createClickablePanel(JPanel myProductPanel,product myProduct) {
        
    	myProductPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	 displayProductAddToCartPanel(myProduct);
            }
        });

        return myProductPanel;
    }
    
    private static void  displayProductAddToCartPanel(product myProduct) {
    	
    	JDialog addToCartFrame=  new JDialog();
    	
    	addToCartFrame.setLayout(new BorderLayout());
    	addToCartFrame.setSize(500, 500);
    	addToCartFrame.setLocationRelativeTo(null);
    	
    	addToCartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	addToCartFrame.setResizable(false);
    	addToCartFrame.setLayout(new BorderLayout());
    	
    	addToCartFrame.setModalityType(ModalityType.APPLICATION_MODAL);
    	
    	JPanel addToCartPanel = new JPanel();
    	addToCartPanel.setBackground(Color.decode(panelBackgroundColor));
    	addToCartPanel.setLayout(new GridLayout(2,2));
    	
    	
		    ImageIcon productImage = new ImageIcon(myProduct.url +myProduct.getProductName()+".jpg");
		    productImage = product.getScaledIcon(productImage, 160, 160);
	    	JPanel image = new JPanel();
	    	image.setBackground(Color.decode(panelBackgroundColor));
	    	image.setBorder(BorderFactory.createEmptyBorder(10, 10,10, 10));
    	image.add(new JLabel(productImage));
    	
		
    		JLabel nameLabel= new JLabel(myProduct.getProductName());
    		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    		nameLabel.setFont(new Font("Georgia", Font.BOLD, 30));
    		nameLabel.setForeground(Color.decode(productsBackgroundColor));
    		nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 5,5, 5));
	    
		JPanel name = new JPanel();
		name.setBackground(Color.decode(panelBackgroundColor));
		name.add(nameLabel);
		
		
	
		
	    
	    JPanel ReviewCommentInput = new JPanel();
	    ReviewCommentInput.setBackground(Color.decode(panelBackgroundColor));
	    JPanel reviewTitle = new JPanel();
	    JLabel reviewTitleLabel = new JLabel("add a review : ");
	    reviewTitleLabel.setFont(new Font("Georgia", Font.BOLD, 20));
	    reviewTitleLabel.setForeground(Color.decode(productsBackgroundColor));
	    
	    
	    reviewTitle.setBackground(Color.decode(panelBackgroundColor));
	    reviewTitle.add(reviewTitleLabel);
	    
	    JPanel reviewTextInput = new JPanel();
	    JTextArea reviewTextInputLabel= new JTextArea();
	    reviewTextInputLabel.setPreferredSize(new Dimension(150,80));
	    
	    reviewTextInputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    reviewTextInput.setBackground(Color.decode(panelBackgroundColor));
	    reviewTextInput.add(reviewTextInputLabel);
	    
	    JPanel reviewSubmit = new JPanel();
	    JButton reviewSubmitButton = new JButton("submit");
	    reviewSubmitButton.setFont(new Font("Georgia", Font.BOLD, 13));
	    reviewSubmitButton.setForeground(Color.decode(productsBackgroundColor));
	    
	    reviewSubmit.setBackground(Color.decode(panelBackgroundColor));
	    reviewSubmitButton.setBackground(Color.decode(panelBackgroundColor));
	    reviewSubmit.add(reviewSubmitButton);
	    
	    
	    reviewSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JOptionPane.showMessageDialog(
		                 null,                  
		                 " thank u for your review  "+
		                 "\n this review will be taken in concediration",         
		                 "Thankx for the review",   // title
		                 JOptionPane.INFORMATION_MESSAGE
		         );
            	 
            	 reviewTextInputLabel.setText("");
            	 
            }
        });
        
	    
	    
	    ReviewCommentInput.setLayout(new BorderLayout());
	    ReviewCommentInput.add(reviewTitle,BorderLayout.NORTH);
	    ReviewCommentInput.add(reviewTextInput,BorderLayout.CENTER);	
	    ReviewCommentInput.add(reviewSubmit,BorderLayout.SOUTH);	
	    
	 
	    	JPanel addToCartButtonPanel = new JPanel();
	    	addToCartButtonPanel.setBackground(Color.decode(panelBackgroundColor));
	    	JButton cart = createSidebarButton("Add to cart");
	    	cart.setFont(new Font("Arial", Font.BOLD, 17));
	    	cart.setContentAreaFilled(true);
	    	cart.setBackground(Color.decode(menuBackgroundColor));
	    	
	    	cart.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	cart.setPreferredSize(new Dimension(110,55));
	    	addToCartButtonPanel.add(cart);
    	
	    	cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(cartIndex <= inCartProductsList.length ) {
            		inCartProductsList[cartIndex]= myProduct;
            		cartIndex++;
            		 
            		}
            	addToCartFrame.dispose();
            	
            }
        });
    	
    	
    	addToCartPanel.add(image);
    	JPanel info = new JPanel();
    	info = myProduct.productInfo();
    	info.setBackground(Color.decode(panelBackgroundColor));
    	addToCartPanel.add(info);
    	addToCartPanel.add(ReviewCommentInput);
    	

    	
    	addToCartFrame.add(name,BorderLayout.NORTH);
    	addToCartFrame.add(addToCartPanel,BorderLayout.CENTER);
    	addToCartFrame.add(addToCartButtonPanel,BorderLayout.SOUTH);
    	
    	addToCartFrame.setVisible(true);
    	
    }
    
    private static void relaodPage(product []productList) {

    	homeFrame.getContentPane().removeAll();
    	
    	
    	JPanel sideMenu = createSidebarMenuPanel(productList);
		homeFrame.add(sideMenu, BorderLayout.WEST);

		JScrollPane mainContent = createMainContentPanel(productList);
		homeFrame.add(mainContent, BorderLayout.CENTER);
    	
		homeFrame.revalidate();
        homeFrame.repaint();
		
    }
    
    private static void displayInCartProducts() {
    	
    	JFrame inCartPoductFrame= initFrame("buying form",500,500);
    	inCartPoductFrame.setLayout(new BorderLayout());
    	inCartPoductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	inCartPoductFrame.setResizable(false);
    	
    	
    	
    	JPanel inCartPoductPanel = new JPanel();
    	inCartPoductPanel.setLayout(new GridLayout(0,1,20,20));
        JPanel marginPanel = new JPanel(new BorderLayout());
        
        inCartPoductPanel.setBackground(Color.decode(productsBackgroundColor));
        
        JScrollPane inCartPoductFormScrolPanel = new JScrollPane(marginPanel);
        inCartPoductFormScrolPanel.setBackground(Color.decode(productsBackgroundColor));
        
        
        inCartPoductPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        marginPanel.add(inCartPoductPanel);
    	
    	
        
        
	 for(int i=0;i<inCartProductsList.length;i++) {
	        	
	        	if (inCartProductsList[i] != null) {
		        	
		        	JPanel myProductPanel = new JPanel();
		        	myProductPanel = inCartProductsList[i].initProductPanel();
		        	inCartPoductPanel.add(myProductPanel);
		        	
	        	}
	
	 }
        
	 
	 JPanel BuyButtonPanel = new JPanel();
	 BuyButtonPanel.setBackground(Color.decode(panelBackgroundColor));
 	JButton buy = createSidebarButton("buy");
 	buy.setFont(new Font("Arial", Font.BOLD, 17));
 	buy.setContentAreaFilled(true);
 	buy.setBackground(Color.decode(menuBackgroundColor));
 	
 	buy.setAlignmentX(Component.CENTER_ALIGNMENT);
 	buy.setPreferredSize(new Dimension(130,70));
 	BuyButtonPanel.add(buy);
 	
	
 	buy.addActionListener(new ActionListener() {
	     @Override
	     public void actionPerformed(ActionEvent e) {
	     	
	    	 if(inCartProductsList[0] != null) {
	    		 
		    	 for(int j=0;j<10;j++) {
					 inCartProductsList[j] = null;
					 cartIndex=0;
					 
		    	 }
		    	
		    	 JOptionPane.showMessageDialog(
		                 null,                  
		                 "Thank you fo your purchase  Mr/Ms "+ UserFullName+
		                 "\n the products are going to be delevered to  :"
		                 + UserAdress,          
		                 "Thank You Message",   
		                 JOptionPane.INFORMATION_MESSAGE
		         );
	    	 
	    	 }
	    	 
	    	 inCartPoductFrame.dispose();			 
	     }
 	});
	
 	
 	
 	 JPanel DeleteButtonPanel = new JPanel();
 	DeleteButtonPanel.setBackground(Color.decode(panelBackgroundColor));
 	JButton Delete = createSidebarButton("empty cart");
 	Delete.setFont(new Font("Arial", Font.BOLD, 10));
 	Delete.setContentAreaFilled(true);
 	Delete.setBackground(Color.decode(exitColor));
 	
 	Delete.setAlignmentX(Component.CENTER_ALIGNMENT);
 	Delete.setPreferredSize(new Dimension(60,40));
 	DeleteButtonPanel.add(Delete);
 	
	
 	Delete.addActionListener(new ActionListener() {
	     @Override
	     public void actionPerformed(ActionEvent e) {
	     	
	    	 for(int i=0;i<inCartProductsList.length;i++) {
		        	
		        	inCartProductsList[i] = null;
		        	inCartPoductFrame.dispose();	
			        		
	    	 }
	    				 
	     }
 	});
 	
 	
 	
 	
 	
 	
        
 		inCartPoductFrame.add(DeleteButtonPanel,BorderLayout.NORTH);
    	inCartPoductFrame.add(inCartPoductFormScrolPanel,BorderLayout.CENTER);
    	inCartPoductFrame.add(BuyButtonPanel,BorderLayout.SOUTH);
    	inCartPoductFrame.setVisible(true);
    	
    }
        
    private static void serchForProduct(String writtenSearchText,boolean searchBy,product []productList){
    	
    	
    	product [] searchedProduct= new product[productList.length];
    	int j=0;
	    	
    	if(searchBy) {
    		
	    	for(int i=0;i<productList.length;i++) {
	    		
	    		if(productList[i].getProductName().equals(writtenSearchText)) {
	    			searchedProduct[j] = productList[i];
	    			j++;
	    		}
	    	}
	    	
    	}else {
			for(int i=0;i<productList.length;i++) {
	    		
	    		if(productList[i].getProductType().equals(writtenSearchText)) {
	    			searchedProduct[j] = productList[i];
	    			j++;
	    		}
	    	}
    		
    	}
	    	
    	
    	 homeFrame.getContentPane().removeAll();
    	
    	JPanel sideMenu = createSidebarMenuPanel(productList);
		homeFrame.add(sideMenu, BorderLayout.WEST);

        
    	if(searchedProduct[0] == null) {
    		
    		JLabel mainContent = new JLabel("item not found");
    		mainContent.setHorizontalAlignment(SwingConstants.CENTER);
    		mainContent.setSize(0,100);
    		mainContent.setFont(new Font("Arial", Font.BOLD, 25));
    		homeFrame.add(mainContent, BorderLayout.CENTER);
    	}else {
    		JScrollPane mainContent = createMainContentPanel(searchedProduct);
    		homeFrame.add(mainContent, BorderLayout.CENTER);
    		 
    	}
    	
      	homeFrame.revalidate();
        homeFrame.repaint();
                
    }	

}
