package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author JunYoung
 *
 *���� 
 *�����̴� ��ǻ�Ϳ� ��ǻ�͸� ��� �����ϴ� ��Ʈ��ũ�� �����Ϸ� �Ѵ�. ������ �ƽ��Ե� ��갡 ���� �ʾ� ��ǻ�Ϳ� ��ǻ�͸�
 *���� �����Ͽ��� �Ѵ�. �׷��� ��ΰ� �ڷḦ �����ϱ� ���ؼ��� ��� ��ǻ�Ͱ� ������ �Ǿ� �־�� �Ѵ�. (a�� b�� ������
 *�Ǿ� �ִٴ� ���� a���� b���� ��ΰ� �����Ѵٴ� ���� �ǹ��Ѵ�. a���� b�� �����ϴ� ���� �ְ�, b�� c�� �����ϴ� ����
 *������ a�� c�� ������ �Ǿ� �ִ�.)
 *
 *�׷��� �̿��̸� ��ǻ�͸� �����ϴ� ����� �ּҷ� �Ͽ��� ��ǻ�͸� �����ϴ� ��� �ܿ� �ٸ� ���� ���� �� �� �� ���� ���̴�.
 *���� �� ��ǻ�͸� �����ϴµ� �ʿ��� ����� �־����� �� ��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ����϶�. ��� ��ǻ�͸�
 *������ �� ���� ���� ����.
 *
 *
 *�Է� ù° �ٿ� ��ǻ���� ��(1<=N<=1000)�� �־�����.
 *
 *��° �ٿ��� ������ �� �ִ� ���� ��(1<=M<=100,000)�� �־�����.
 *
 *��° �ٺ��� M+2��° �ٱ��� �� M���� �ٿ� �� ��ǻ�͸� �����ϴµ� ��� ����� �־�����. �� ����� ������ �� ����
 *������ �־����µ�, ���࿡ a b c �� �־��� �ִٰ� �ϸ� a��ǻ�Ϳ� b��ǻ�͸� �����ϴµ� ����� c��ŭ ��ٴ� ����
 *�ǹ��Ѵ�.
 *
 *6 
 *9 
 *1 2 5 
 *1 3 4 
 *2 3 2 
 *2 4 7 
 *3 4 6 
 *3 5 11 
 *4 5 3 
 *4 6 8 
 *5 6 8
 *
 *��� 
 *��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ù° �ٿ� ����Ѵ�.
 *
 *23
 *
 */
public class NetworkConnection {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Network> list = new ArrayList<Network>();
		int from, to, weight;
		int total=0;
		
		int numOfComputers = scan.nextInt();
		int numLines = scan.nextInt();
		int[] spanningTree = new int[numOfComputers+1];
		
		Arrays.fill(spanningTree, -1);

		for (int i = 0; i < numLines; i++) {
			from = scan.nextInt();
			to = scan.nextInt();
			weight = scan.nextInt();

			Network network = new Network(from, to, weight);
			list.add(network);
		}
		
		List<Network>sortedList = list.stream()
				.sorted((o1, o2)->(o1.weight<o2.weight)?-1:1)
				.collect(Collectors.toList());
		
		for(Network network : sortedList) {
			if(findRoot(spanningTree, network.from) != network.from) {
				
			}
		}
		
		System.out.println(total);
		
		scan.close();
	}
	
	static int findRoot(int[] arr, int vertex) {
		int index = vertex;
		while(arr[index] != -1) {
			index = arr[index];
		}
		return index;
	}
	
	static class Network {
		int from;
		int to;
		int weight;

		Network(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

}
