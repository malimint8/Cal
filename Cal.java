import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Cal {
	double total = 0;
	double bmr;
	ArrayList<Double> food = new ArrayList<>();

	public void insert(double cal) {
		food.add(cal);
	}
	public void delete(int d) {
		food.remove(d);
	}
	public double getsum() {
		total = 0;
		for(int i=0;i<food.size();i++){
			 total = total + food.get(i);
		}
		return total;
	}
	public boolean checkcal() {
		if(getsum()>bmr) {
			return true;
		}else {
			return false;
		}		
	}
	public double bmrmale(double w,double h,int a) {
		bmr = (66+(13.7*w)+(5*h)-(6.8*a));
		return bmr;
	}
	public double bmrfemale(double w,double h,int a) {
		bmr = (665+(9.6*w)+(1.8*h)-(4.7*a));
		return bmr;
	}
	
}

