package tryHelloWorld;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoOverTime {
	public int noOvertime(int no, int[] works) {
		int result = 0;
		// 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?
		Map<String, String> hMap = new HashMap<String, String>();
		Map<String, String> listMap = new LinkedHashMap<String, String>();
		
		hMap.put("a", "aaa");
		hMap.put("a", "bbb");
		hMap.put("b", "ccc");
		
		System.out.println(hMap.entrySet());
		
		listMap.put("a", "aaa");
		listMap.put("b", "ccc");
		
		System.out.println(listMap.entrySet());
		
		return result;
	}

	public static void main(String[] args) {
		NoOverTime c = new NoOverTime();
		int[] test = { 4, 3, 3 };
		System.out.println(c.noOvertime(4, test));
	}
}
