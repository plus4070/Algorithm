package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.
 *
 *1	0	1	1	1	1
 *1	0	1	0	1	0
 *1	0	1	0	1	1
 *1	1	1	0	1	1
 *�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ�
 *(N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *
 *���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.
 *
 *�Է�
 *ù° �ٿ� �� ���� N, M(2��N, M��100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������ �پ �Է����� �־�����.
 *
 *4 6
 *101111
 *101010
 *101011
 *111011
 *
 *4 6
 *110110
 *110110
 *111111
 *111101
 *
 *���
 *ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. �׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.
 *
 *15
 *
 *9
 *
 * */
public class MazeRunner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] line = scan.nextLine().split(" ");
		int height = Integer.parseInt(line[0]);
		int width = Integer.parseInt(line[1]);

		int[][] maze = new int[height][width];

		for (int i = 0; i < height; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < width; j++) {
				maze[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		System.out.println(findWayOut(maze, height, width));
		scan.close();
	}

	private static  int findWayOut(int[][] maze, int height, int width) {
		int pos = 0;
		int cnt = 1;
		int size = height * width;

		int[] x = new int[size];		//x��ǥ
		int[] y = new int[size];		//y��ǥ
		int[] len = new int[size];	//�����Ÿ�
		
		//����
		x[0] = 0;
		y[0] = 0;
		len[0] = cnt;
		
		while(pos < size && (x[pos] != height-1 || y[pos] != width-1)) {
			//���������� ǥ��
			maze[x[pos]][y[pos]] = 0;
			
			//�Ʒ� Ȯ��
			if(x[pos]+1 < height && maze[x[pos]+1][y[pos]] == 1) {
				x[cnt] = x[pos] + 1;
				y[cnt] = y[pos];
				len[cnt] = len[pos]+1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//������ Ȯ��
			if(y[pos]+1 < width && maze[x[pos]][y[pos]+1] == 1) {
				x[cnt] = x[pos];
				y[cnt] = y[pos]+1;
				len[cnt] = len[pos]+1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//�� Ȯ��
			if(x[pos]-1 >= 0 && maze[x[pos]-1][y[pos]] == 1) {
				x[cnt] = x[pos] - 1;
				y[cnt] = y[pos];
				len[cnt] = len[pos] + 1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//����Ȯ��
			if(y[pos]-1 >= 0 && maze[x[pos]][y[pos]-1] == 1) {
				x[cnt] = x[pos];
				y[cnt] = y[pos]-1;
				len[cnt] = len[pos] + 1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			pos++;
			
		}
		
		return len[pos];
	}

}
