import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author santoshrayala
 *
 */
public class PrintOutput {
	
	ExtractFeatures ef= new ExtractFeatures();
	Map<Integer, Features> featureMap = new HashMap<Integer, Features>();

	void print(List<Double> c, double threshold, String outfileprefix)
	{
		featureMap.clear();
		System.out.println("Calculating the features in the voltage plots in a sample of 5 seconds.");
		
		featureMap=ef.compute(5, c, threshold);
		

	
	System.out.println("Starting to write the output for channel "+outfileprefix+"...");
	
	Writer writer = null;

	try {
	    writer = new BufferedWriter(new OutputStreamWriter(
	          new FileOutputStream("C:/Users/santoshrayala/Desktop/PhysiomimiWork/openvibe/output/output"+outfileprefix.trim()+".txt"), "utf-8"));
	    
	    
	    writer.write("Sample NO. \t\t Peak voltage \t\t Lowest voltage \t\t peak and low dist.\t\t"
	    		+ " Avg. voltage \t\t No.of Peaks"+System.lineSeparator());
	    int noofsamples= c.size()/(128*5);
	    for(int i=1; i<=noofsamples; i++)
	    {
	    	writer.write(i+ "\t\t\t\t"+featureMap.get(i).getPeak()+"\t\t\t\t"+featureMap.get(i).getLow()+
	    			"\t\t\t\t"+featureMap.get(i).getDistbwpeaklow()+"\t\t\t\t"+featureMap.get(i).getAvg()
	    			+"\t\t\t\t"+featureMap.get(i).getNoofpeaks()+System.lineSeparator());
	    }
	    
	    
	} catch (IOException ex) {
	  
	} finally {
	   try {writer.close();} catch (Exception ex) {}
	}
	
	
	System.out.println("Process Finished. Check the output"+outfileprefix.trim()+".txt in the provided path for the output");
	}
}
