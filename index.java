import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class index extends JFrame implements ActionListener{
	private JFrame frame;
	private JTextField weight,age,height,meal,cals;
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	JButton addbtn = new JButton("add");
	JLabel resultLabel = new JLabel();
	JLabel total = new JLabel("....");
	Cal cal = new Cal();
	double w,h,bmr;
	int a;
	//table
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	Object[] column = {"Meal","Calories"};
	final Object[] row = new Object[2];
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.frame.setVisible(true);
					window.frame.setSize(new Dimension(700, 370));
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame(); //frame
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 706, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Calories");
		title.setBackground(new Color(255, 255, 255));
		title.setBounds(0, 11, 690, 29);
		title.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(title);
		
		JPanel personal = new JPanel();
		personal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		personal.setBackground(new Color(204, 255, 255));
		personal.setBounds(0, 40, 252, 293);
		frame.getContentPane().add(personal);
		personal.setLayout(null);
		
		JLabel weightla = new JLabel("Weight(kg.)");
		weightla.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		weightla.setHorizontalAlignment(SwingConstants.CENTER);
		weightla.setBounds(10, 13, 102, 37);
		personal.add(weightla);
		weight = new JTextField(); 
		weight.setBounds(122, 19, 107, 20);
		personal.add(weight);
		weight.setColumns(5);
		JLabel heightla = new JLabel("Height(cm.)");
		heightla.setHorizontalAlignment(SwingConstants.CENTER);
		heightla.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		heightla.setBounds(10, 61, 97, 28);
		personal.add(heightla);
		height = new JTextField(); 
		height.setBounds(122, 63, 107, 20);
		personal.add(height);
		height.setColumns(5);
		JLabel agela = new JLabel("Age");
		agela.setHorizontalAlignment(SwingConstants.CENTER);
		agela.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		agela.setBounds(10, 100, 97, 37);
		personal.add(agela);
		age = new JTextField();
		age.setBounds(122, 106, 107, 20);
		personal.add(age);
		age.setColumns(5);
		male.setBackground(new Color(204, 255, 255));
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setBounds(31, 148, 76, 23);
		
		//JRadioButton male = new JRadioButton("Male");
		personal.add(male);
		female.setBackground(new Color(204, 255, 255));
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setBounds(149, 148, 80, 23);
		personal.add(female);
		
	
		JButton button = new JButton("Submit");
		button.setBackground(new Color(255, 255, 204));
		button.setForeground(Color.BLACK);
		button.setBounds(70, 239, 107, 28);
		personal.add(button);
		button.addActionListener(this);
		
		JPanel resultpanel = new JPanel();
		resultpanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		resultpanel.setBackground(new Color(204, 255, 255));
		resultpanel.setBounds(274, 40, 416, 293);
		frame.getContentPane().add(resultpanel);
		resultpanel.setLayout(null);
		
		JLabel bmrLabel = new JLabel("  Your BMR is   ");
		bmrLabel.setBounds(24, 10, 118, 27);
		bmrLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		resultpanel.add(bmrLabel);
		
		resultLabel = new JLabel("..."); 
		resultLabel.setBounds(141, 10, 54, 22);
		resultLabel.setVerticalAlignment(SwingConstants.TOP);
		resultLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		resultpanel.add(resultLabel);
		
		JLabel meallabel = new JLabel("Food");
		meallabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		meallabel.setBounds(38, 36, 41, 27);
		resultpanel.add(meallabel);
		
		meal = new JTextField();
		meal.setBounds(71, 36, 86, 20);
		resultpanel.add(meal);
		meal.setColumns(10);
		
		JLabel callabel = new JLabel("Calories");
		callabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		callabel.setBounds(167, 42, 82, 14);
		resultpanel.add(callabel);
		
		cals = new JTextField();
		cals.setBounds(216, 36, 86, 20);
		resultpanel.add(cals);
		cals.setColumns(10);
		addbtn.setBackground(new Color(255, 255, 204));
		
		
		addbtn.setBounds(48, 254, 70, 28);
		resultpanel.add(addbtn);
		addbtn.addActionListener(this);
		total.setVerticalAlignment(SwingConstants.TOP);
		total.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		total.setBounds(288, 10, 118, 22);
		resultpanel.add(total);
		//table
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		table.setBounds(38, 64, 334, 170);
		table.setModel(model);
		resultpanel.add(table);
	
		
		JButton sumcal = new JButton("sum");
		sumcal.setBackground(new Color(255, 255, 204));
		sumcal.setBounds(171, 254, 70, 28);
		resultpanel.add(sumcal);
		sumcal.addActionListener(this);
		
		JButton deletebtn = new JButton("delete");
		deletebtn.setBackground(new Color(255, 255, 204));
		deletebtn.setBounds(283, 254, 70, 28);
		resultpanel.add(deletebtn);
		deletebtn.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event){
		// TODO Auto-generated method stub
		String buttonName =((JButton)event.getSource()).getText();
	
		
		if(weight.getText().equals("")||height.getText().equals("")||age.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Please fill complete information");
		}else {
			w  = Double.parseDouble(weight.getText());
			h  = Double.parseDouble(height.getText());
			a  = Integer.parseInt(age.getText());
		}
		if(buttonName.equals("Submit")) {
			if(male.isSelected()&&!female.isSelected()) {
				bmr = cal.bmrmale(w,h,a);
				resultLabel.setText(Double.toString(bmr));
				
			}else if(female.isSelected()&&!male.isSelected()) {
				bmr = cal.bmrfemale(w,h,a);
				resultLabel.setText(Double.toString(bmr));
			}else {
				JOptionPane.showMessageDialog(null,"Please select only one");
			}
		}
		
		if(buttonName.equals("add")) {
			if(meal.getText().equals("")||cals.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please fill complete information");
			}else {
				try {
					double dcals = Double.parseDouble(cals.getText());
					cal.insert(dcals);
					addData();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Please fill only number");
				}
			}
		}
		if(buttonName.equals("sum")) {
			total.setText("Cal = "+Double.toString(cal.getsum()));
			if(cal.checkcal()) { //check if cal sum > bmr
				JOptionPane.showMessageDialog(null,"You should not eat anymore");
			}else {
				
			}
			
		}
		if(buttonName.equals("delete")) {
			deleteData();
			System.out.print("d");
		}
	
	}
		
	

	public void addData() { //add row in table
		model.setColumnIdentifiers(column);
		row[0] = meal.getText();
		row[1] = Double.parseDouble(cals.getText());
		model.addRow(row);
		cals.setText("");
		meal.setText("");
		
	}
	public void deleteData() { //delete row in table
		if(table.getRowCount()>=1) {
			int row = table.getSelectedRow();
			model.removeRow(row);
			cal.delete(row);
		}else {
			if(table.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"Table is empty");
			}
		}
	}
}
