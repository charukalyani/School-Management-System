import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchFaculty extends JFrame implements ActionListener{

            Container cont;
            JPanel jPanel;
            JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
            JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14;
            JRadioButton male,female;
            ButtonGroup bg;
            JComboBox classbox,quali,desi;
            JButton save,search;
            String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
            Connection conn;
	    PreparedStatement psmt;
            Statement stm2;
	    ResultSet rs2 ;
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            String userName = "System";
            String password = "System";
            int pass,pass2,check1,check2,check3;
            String dl; 
            SearchFaculty(){
                 cont = getContentPane();
                 setLayout(null);
                 setSize(600,550);

                 setTitle("SCHOOL MANAGEMENT SYSTEM");

                 jPanel = new JPanel();
                 jPanel.setLayout(null);
                 jPanel.setBounds(0,0,600,600);
                 jPanel.setBackground(Color.green);
                  setResizable(false);
                 JLabel logo = new JLabel(new ImageIcon("icons/logo.png"));
                 logo.setBounds(120,10,60,60);  
                   setIconImage(new ImageIcon("icons/logo.png").getImage());             
                 jPanel.add(logo);
                 
                 JLabel heading = new JLabel("Search Staff ");
                 heading.setBounds(180,5,350,100);  
                 heading.setFont(new Font("Ravie",Font.BOLD,25));              
                 jPanel.add(heading);

                 /*******GUI******/
                 l1 = new JLabel("ID :");
                 l1.setBounds(70,80,50,25);
                 l2 = new JLabel("Name :");
                 l2.setBounds(70,120,50,25);
                 l3 = new JLabel("Father Name :");
                 l3.setBounds(70,160,100,25);
                 l4 = new JLabel("Religion :");
                 l4.setBounds(70,200,100,25);
                 l5 = new JLabel("Nationality :");
                 l5.setBounds(280,200,100,25);
                 l6 = new JLabel("Address :");
                 l6.setBounds(70,240,100,25);
                 l7 = new JLabel("Mobile no :");
                 l7.setBounds(70,280,100,25);
                 l8 = new JLabel("City :");
                 l8.setBounds(280,280,100,25);
                 l9 = new JLabel("Gender :");
                 l9.setBounds(70,320,100,25);
                 l10 = new JLabel("Salary :");
                 l10.setBounds(320,320,90,25);
                 l11 = new JLabel("D.O.B :");
                 l11.setBounds(70,360,100,25);
                 l12 = new JLabel("Joining Date :");
                 l12.setBounds(260,360,100,25);
                 l13 = new JLabel("Qualification :");
                 l13.setBounds(70,400,100,25);
                 l14 = new JLabel("Designation :");
                 l14.setBounds(280,400,100,25);



                 ltf1 = new JTextField();
                 ltf1.setBounds(140,80,340,25);
                 ltf2 = new JTextField();
                 ltf2.setBounds(140,120,340,25);
                 ltf3 = new JTextField();
                 ltf3.setBounds(180,160,300,25);
                 ltf4 = new JTextField();
                 ltf4.setBounds(140,200,120,25);
                 ltf5 = new JTextField();
                 ltf5.setBounds(360,200,120,25);
                 ltf6 = new JTextField();
                 ltf6.setBounds(140,240,340,25);
                 ltf7 = new JTextField();
                 ltf7.setBounds(140,280,120,25);
                 ltf8 = new JTextField();
                 ltf8.setBounds(340,280,140,25);
                 ltf9 = new JTextField();
                 male = new JRadioButton("Male");
                 male.setBackground(Color.green);
                 male.setBounds(140,320,60,25);
                 male.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                        	if(e.getItemSelectable()==male){
                                       ltf9.setText("Male");
                                }
                        } 
                 });

                 female = new JRadioButton("Female");
                 female.setBackground(Color.green);
                 female.setBounds(220,320,80,25);
                 female.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                        	if(e.getItemSelectable()==female){
                                       ltf9.setText("Female");
                                }
                        } 
                 });
                 bg = new ButtonGroup();
                 bg.add(male);
                 bg.add(female);

                 ltf10 = new JTextField(); 
		 ltf10.setBounds(360,320,120,25);
	       	
                 ltf11 = new JTextField();
                 ltf11.setBounds(140,360,110,25);
                 ltf12 = new JTextField();
                 ltf12.setBounds(360,360,120,25);
                 ltf13 = new JTextField();
        
                 quali = new JComboBox();
		 quali.setBounds(160,400,110,25);
	       	 quali.addItem("");
	         quali.addItem("B.A");
		 quali.addItem("M.A");
		 quali.addItem("B.com");
		 quali.addItem("M.com");
		 quali.addItem("B.Sc");
		 quali.addItem("M.Sc");
		 quali.addItem("B.Tech");
		 quali.addItem("M.Tech");
		 quali.addItem("10 th");
		 quali.addItem("12 th");
		 quali.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent i){
					if(i.getStateChange()==ItemEvent.SELECTED){
						ltf13.setText((String) i.getItem());
					}
				}
			});
                 ltf14 = new JTextField();
                 desi = new JComboBox();
		 desi.setBounds(360,400,120,25);
	       	 desi.addItem("");
	         desi.addItem("Teacher");
		 desi.addItem("Principal");
		 desi.addItem("Faculty");
		 desi.addItem("Guard");
		 desi.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent i){
					if(i.getStateChange()==ItemEvent.SELECTED){
						ltf14.setText((String) i.getItem());
					}
				}
			});

                
             
                 search = new JButton("Search");
                 search.setBackground(new Color(128,128,255));
                 search.setBounds(70,460,410,25);
                 search.addActionListener(this);

                 jPanel.add(l1);
                 jPanel.add(l2);
                 jPanel.add(l3);
                 jPanel.add(l4);
                 jPanel.add(l5);
                 jPanel.add(l6);
                 jPanel.add(l7);
                 jPanel.add(l8);
                 jPanel.add(l9);
                 jPanel.add(l10);
                 jPanel.add(l11);
                 jPanel.add(l12);
                 jPanel.add(l13);
                 jPanel.add(l14);
                 

                 jPanel.add(ltf1);
                 jPanel.add(ltf2);
                 jPanel.add(ltf3);
                 jPanel.add(ltf4);
                 jPanel.add(ltf5);
                 jPanel.add(ltf6);                 
                 jPanel.add(ltf7);
                 jPanel.add(ltf8);
                 jPanel.add(male);
                 jPanel.add(female);
                 jPanel.add(ltf10);
                 jPanel.add(ltf11);
                 jPanel.add(ltf12);
                 jPanel.add(quali);
                 jPanel.add(desi);
                
                 jPanel.add(search);
                 
                 cont.add(jPanel);
                 setLocationRelativeTo(null);
                 setVisible(true);
                 try{ Class.forName("oracle.jdbc.driver.OracleDriver");
                    }catch(Exception cnf){ JOptionPane.showMessageDialog(this,cnf,"Error",JOptionPane.ERROR_MESSAGE);}
                 
                
            }
   
     public void actionPerformed(ActionEvent e){
                  s1="";s2="";s3="";s4="";s5="";s6="";s7="";s8="";s9="";s10="";s11="";s12=""; s13="";s14="";                      
                   
          if(e.getSource()==search){
						int de=0;
						dl=JOptionPane.showInputDialog(this,"Enter ID");
						if(!dl.isEmpty()){
								try{ 	
			                               			conn = DriverManager.getConnection(url,userName,password);
									stm2=conn.createStatement();
									rs2=stm2.executeQuery("Select id from faculty");
									while (rs2.next())
									{
										if(dl.equals(rs2.getString(1)))
										{
											de=1; 
											break;
										}
									} 
									conn.close();
								}catch(Exception ep){}
							if(de==1){ 

								try{	
					
									conn = DriverManager.getConnection(url,userName,password);
									stm2=conn.createStatement();
									rs2= stm2.executeQuery("SELECT  *  FROM faculty WHERE id="+dl+" ");
						
									while(rs2.next())
									{
					
									ltf1.setText(rs2.getString(1));
									ltf2.setText(rs2.getString(2));
									ltf3.setText(rs2.getString(3));
									ltf4.setText(rs2.getString(4));
									ltf5.setText(rs2.getString(5));
									ltf6.setText(rs2.getString(6));
									ltf7.setText(rs2.getString(7));
									ltf8.setText(rs2.getString(8));
									ltf9.setText(rs2.getString(9));
									ltf10.setText(rs2.getString(10));
									ltf11.setText(rs2.getString(11));
									ltf12.setText(rs2.getString(12));
                                                                        ltf13.setText(rs2.getString(13));
									ltf14.setText(rs2.getString(14));
									
									}
									String sk = ltf9.getText();
									String sk2 = ltf10.getText();
                                                                        String sk3 = ltf13.getText();
                                                                        String sk4 = ltf14.getText();
									
									if(sk.equalsIgnoreCase("Male")){ male.setSelected(true);}
									else{ female.setSelected(true);}
									quali.setSelectedItem(sk3);
                                                                        desi.setSelectedItem(sk4);
									conn.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(this,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(this,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(this,"Search field is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}

     }
    
     public static void main(String []args){
               new SearchFaculty();
     }


}