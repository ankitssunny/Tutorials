package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords {
	private Integer index;
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
	
		String line= reader.readLine();
		StringBuilder reverse=new StringBuilder();
		//line : this is a line -> line a is this
		String[] word= line.split(" ");
		for(int i=word.length-1; i>0; i--)
			reverse.append(word[i]+" ");
		reverse.append(word[0]);
		System.out.println("Case #" +count+ ": " +reverse.toString());
		count++;
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		ReverseWords rw= new ReverseWords();
		Long start= System.currentTimeMillis();
		rw.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}
