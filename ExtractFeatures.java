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
public class ExtractFeatures {
	Map<Integer, Features> featureMap =new HashMap<Integer, Features>();

	public Map<Integer, Features> compute(int epochsize, List<Double> c,  double threshold) {
		// TODO Auto-generated method stub
		featureMap.clear();
	double peak=0.0, low=0.0, timeatpeak=0.0, timeatlow=0.0;
	double avg=0.0;
	int sampleno=1;
	int noofpeaks=0;
	double dist=0.0;
	int count =128*epochsize;
	int forcount=1;
	for(double volt: c)
	{
		avg+=volt;
		if(volt>threshold) noofpeaks++;
		if(peak==0.0) peak=volt;
		if(low==0.0) low=volt;
		if(volt>peak){ 
			peak=volt;
			timeatpeak=forcount;
		}
		if(volt<low) {
			low=volt;
			timeatlow=forcount;
		}
		forcount++;
		if(forcount%count==0) {		//denotes the end of an epoch
			Features features = new Features();
			avg=avg/count;		//avg is the sum of all voltages in an epoch divided by epoch size
			dist = (Math.abs(timeatlow-timeatpeak)); //dist is the time difference @peak and low ie,. the no. of samples
			features.setPeak(peak);
			features.setLow(low);
			features.setNoofpeaks(noofpeaks);
			features.setDistbwpeaklow(dist);
			features.setAvg(Math.abs(avg));
			featureMap.put(sampleno, features);
			avg=0.0;
			noofpeaks=0;
			peak=0.0;
			low=0.0;
			sampleno++;
		}
		
	}
	return featureMap;	
	}

}
