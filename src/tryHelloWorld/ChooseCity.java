package tryHelloWorld;

class ChooseCity {
	public int chooseCity(int n, int[][] city) {
		int answer = 0;
		int price = 0, oldPrice = 9999;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++ ){
				if(i==j){
					continue;
				}else{
					price += Math.abs(i-j) * city[j][1];
				}
			}
			if(price < oldPrice) {
				answer = i+1;
				oldPrice = price;
			}
			price = 0;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		ChooseCity test = new ChooseCity();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}
}