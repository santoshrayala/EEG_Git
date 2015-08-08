import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * program written to remove DC offset in the OpenBCI text output.
 * Code taken from EEGDataAnalysis project
 * Change the input file path and output file path before running the program
 * @author santoshrayala
 *
 */
public class removeOffset {
	
	static List<Double> c1=new ArrayList<Double>();
	static List<Double> c2=new ArrayList<Double>();
	static List<Double> c3=new ArrayList<Double>();//contains O1 channel data
	static List<Double> c4=new ArrayList<Double>();
	static List<Double> c5=new ArrayList<Double>();
	static List<Double> c6=new ArrayList<Double>();
	static List<Double> c7=new ArrayList<Double>();
	static List<Double> c8=new ArrayList<Double>();//contains PO3 channel data
	static List<Double> c9=new ArrayList<Double>();
	static List<Double> c10=new ArrayList<Double>();
	static List<Double> c11=new ArrayList<Double>();
	static List<Double> c12=new ArrayList<Double>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path_Name="C:/Users/santoshrayala/Desktop/PhysiomimiWork/OpenBCI-RAW-2015-04-06_20-31-55.txt";
		String delim=";, ";
		double meanforc3 = 0.0;
		double meanforc8 = 0.0;
		//NumberFormat nf = NumberFormat.getInstance();
	    //nf.setMinimumFractionDigits(7);
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(path_Name));
			StringTokenizer st;
			String line;
			Double d;
			int nooflinestoremove = 3;
			while((line = br.readLine())!=null && nooflinestoremove>=0)
			{
				nooflinestoremove--;
			}
			while((line = br.readLine())!=null)
			{
				st=new StringTokenizer(line, delim, false);
				int flag=1;
				while(st.hasMoreTokens())
				{
					
					String value=st.nextToken();
					switch(flag)
					{
					case 1:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c1.add(d);
						break;
					case 2:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c2.add(d);
						break;
					case 3:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						meanforc3+=d;
						c3.add(d);
						break;
					case 4:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c4.add(d);
						break;
					case 5:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c5.add(d);
						break;
					case 6:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c6.add(d);
						break;
					case 7:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c7.add(d);
						break;
					case 8:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						meanforc8+=d;
						c8.add(d);
						break;
					case 9:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c9.add(d);
						break;
					case 10:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c10.add(d);
						break;
					case 11:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c11.add(d);
						break;
					case 12:
						d = Double.parseDouble(value);
						//d=Double.parseDouble(nf.format(d));
						c12.add(d);
						break;
					
					}
					flag++;
				}
				//arrayposition++;
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Starting to remove the DC offset in the data...");
		
		meanforc3=meanforc3/c3.size(); //calculating DC offset for O1
		meanforc8=meanforc8/c8.size(); //calculation DC offset for PO3
		
		//Writing to the output file
		
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("C:/Users/santoshrayala/Desktop/PhysiomimiWork/output1.txt"), "utf-8"));
		    
		    
		    
		    int noofvalues= c3.size();
		    for(int i=0; i<noofvalues; i++)
		    {
		    	writer.write((c3.get(i)-meanforc3)+", "+ (c8.get(i)-meanforc8)+System.lineSeparator());
		    }
		    
		    
		} catch (IOException ex) {
		  
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
		
		System.out.println("Process finished, Check the output file...");
		
		
		

	}

}
