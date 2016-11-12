package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HowFoxCry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int times = Integer.parseInt(scan.nextLine());
		Map<String, String> cry = new HashMap<String, String>();
		
		for(int j = 0; j<times; j++) {
			String crySound = scan.nextLine();
			while(true){
				String animalSound = scan.nextLine();
				
				if(animalSound.contains("goes")) {
					String[] words = animalSound.split(" ");
					cry.put(words[0], words[2]);
				} else if(animalSound.contains("?")) {
					String[] question = animalSound.split(" ");
					if(cry.containsKey(question[3])) {
						System.out.println(cry.get(question[3]));
						break;
					} else {
						StringBuffer sb = new StringBuffer();
						String[] sounds = crySound.split(" ");
						for(int i=0; i<sounds.length; i++ ){
							if(!cry.containsValue(sounds[i])) {
								sb.append(sounds[i]+" ");
							}
						}
						System.out.println(sb);
						break;
					}
				}
			}
		}
		
		scan.close();
	}

}
