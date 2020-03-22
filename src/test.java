import javax.swing.JOptionPane;
public class test {

	public static void main(String[] args) {
		ManagementCompany m;
		Property p1,p2,p3;
		m = new ManagementCompany("Manage", "1234", 10);
		//student add three properties, with plots, to mgmt co
		p1 = new Property("AAA","RV",3000,"Hohn",2,2,2,2);
		p2 = new Property("BBB","RV",2000,"Iohn",4,4,2,2);
		p3 = new Property("CCC","RV",1000,"John",3,1,1,1);
		if(p1.getPlot().overlaps(p2.getPlot()))
			JOptionPane.showMessageDialog(null, "p1 p2 overlap");
		if(p1.getPlot().overlaps(p3.getPlot()))
			JOptionPane.showMessageDialog(null, "p1 p3 overlap");
		if(p2.getPlot().overlaps(p3.getPlot()))
			JOptionPane.showMessageDialog(null, "p2 p3 overlap");
		
		JOptionPane.showMessageDialog(null, "Done");
	}

}
