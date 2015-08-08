import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


import flanagan.math.*;
public class OpenBCIOutputAnalysis {
	
	static List<Double> t=new ArrayList<Double>();//for time
	static List<Double> c1=new ArrayList<Double>();
	static List<Double> c2=new ArrayList<Double>();
	static List<Double> c3=new ArrayList<Double>();
	static List<Double> c4=new ArrayList<Double>();
	static List<Double> c5=new ArrayList<Double>();
	static List<Double> c6=new ArrayList<Double>();
	static List<Double> c7=new ArrayList<Double>();
	static List<Double> c8=new ArrayList<Double>();
	static List<Double> c9=new ArrayList<Double>();
	static List<Double> c10=new ArrayList<Double>();
	static List<Double> c11=new ArrayList<Double>();
	static List<Double> c12=new ArrayList<Double>();
	static List<Double> c13=new ArrayList<Double>();
	static List<Double> c14=new ArrayList<Double>();
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path_Name="C:/Users/santoshrayala/Desktop/PhysiomimiWork/openvibe/output/alpha.txt";
		String delim=";, ";
		NumberFormat nf = NumberFormat.getInstance();
	    nf.setMinimumFractionDigits(7);
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(path_Name));
			StringTokenizer st;
			String line;
			Double d;
			
			while((line = br.readLine())!=null)
			{
				st=new StringTokenizer(line, delim, false);
				int flag=0; //flag starts from 0, thus skipping the first value in Switch statement
				while(st.hasMoreTokens())
				{
					String value=st.nextToken();
					switch(flag)
					{
					case 0:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						t.add(d);
						break;
					case 1:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c1.add(d);
						break;
					case 2:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c2.add(d);
						break;
					case 3:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c3.add(d);
						break;
					case 4:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c4.add(d);
						break;
					case 5:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c5.add(d);
						break;
					case 6:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c6.add(d);
						break;
					case 7:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c7.add(d);
						break;
					case 8:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c8.add(d);
						break;
					case 9:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c9.add(d);
						break;
					case 10:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c10.add(d);
						break;
					case 11:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c11.add(d);
						break;
					case 12:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c12.add(d);
						break;
					case 13:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c13.add(d);
						break;
					case 14:
						d = Double.parseDouble(value);
						d=Double.parseDouble(nf.format(d));
						c14.add(d);
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
		Scanner S = new Scanner(System.in);
		
		double[] c1d = new double[c1.size()];
		 for (int i = 0; i < c1.size(); i++) {
		    c1d[i] = c1.get(i);
		 }

		System.out.println("Enter the voltage threshold to calculate the no of peaks above the threshold: ");
		double threshold=S.nextDouble();
		PrintOutput po = new PrintOutput();
		
		
		/*FourierTransform ft = new FourierTransform(c1d);
		ft.setDeltaT(1/128);
		double[][] powerSpectrum = ft.powerSpectrum();
		double[][] psd = ft.getpowerSpectrumEstimate();
		ft.printPowerSpectrum("psd1.txt");

        // Plot power spectrum
        ft.plotPowerSpectrum();
        */
        
		po.print(c1, threshold, "AF3");
		po.print(c2, threshold, "F7");
		po.print(c3, threshold, "F3");
		po.print(c4, threshold, "FC5");
		po.print(c5, threshold, "T7");
		po.print(c6, threshold, "P7");
		po.print(c7, threshold, "O1");
		po.print(c8, threshold, "O2");
		po.print(c9, threshold, "P8");
		po.print(c10, threshold, "T8");
		po.print(c11, threshold, "FC6");
		po.print(c12, threshold, "F4");
		po.print(c13, threshold, "F8");
		po.print(c14, threshold, "AF4");
		

		S.close();
		

	}
	
}
