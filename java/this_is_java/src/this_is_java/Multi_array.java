package this_is_java;

public class Multi_array {

	public static void main(String[] args) {
		int[][] scores = {
				{89,90,96},
				{76,88}	
		};
		
		System.out.println("1차원 배열의 길이 : " + scores.length);
		
		int totalStudent = 0;
		int totalSum =0;
		for(int i = 0; i<scores.length; i++) { //2회 반복  i=0 ts1
			totalStudent += scores[i].length; 
			for(int j=0; j<scores[i].length; j++) {
				totalSum += scores[j].length;	
			} 
		}
	
	
	}

}
