package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class StoreCredit {

	private int index, credit;
	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	static int count=1;
	public void testcases() throws NumberFormatException, IOException{
		index= Integer.parseInt(reader.readLine());
		while(index != 0){
			testcase();
			index--;
		}
	}

	public void testcase() throws IOException{
		
		HashMap<Integer, List<Integer>> priceWithPosition= new HashMap<Integer, List<Integer>>();
		credit=Integer.parseInt(reader.readLine());
		Integer.parseInt(reader.readLine());
		String [] price= reader.readLine().split(" ");
		for(int i=0; i<price.length; i++){
			Integer pr=Integer.parseInt(price[i]);
			if(priceWithPosition.containsKey(pr))
				priceWithPosition.get(pr).add(i+1);
			else{
				List<Integer> a1 = new ArrayList<Integer>();
				a1.add(i+1);
				priceWithPosition.put(pr,a1);
			}
		}
		
		
		for(Entry<Integer, List<Integer>> entry : priceWithPosition.entrySet()) {
			Integer First=	entry.getKey();
			Integer indexFirst=0;
			Integer Second=0;
			Integer indexSecond=0;
			List<Integer> indexList=priceWithPosition.get(First);
			int remaining= credit - First;
			indexFirst=(Integer) indexList.get(0);
			if(remaining == First && indexList.size() == 2 ){
				indexSecond=(Integer) indexList.get(1);
				Second= remaining;
				System.out.println("Case #" +count+ ": " +indexFirst+ " " +indexSecond);
				break;
			}
			
			if(priceWithPosition.containsKey(remaining)){
				Second= remaining;
				indexSecond= priceWithPosition.get(Second).get(0);
				if(indexFirst < indexSecond)
					System.out.println("Case #" +count+ ": " +indexFirst+ " " +indexSecond);
				else
					System.out.println("Case #" +count+ ": " +indexSecond+ " " +indexFirst);
			
				break;
			}
		}
	count++;
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		StoreCredit sc= new StoreCredit();
		Long start= System.currentTimeMillis();
		sc.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}
