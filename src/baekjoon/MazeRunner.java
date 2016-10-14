package baekjoon;

import java.util.Scanner;

/**
 * @author JunYoung
 *
 *N×M크기의 배열로 표현되는 미로가 있다.
 *
 *1	0	1	1	1	1
 *1	0	1	0	1	0
 *1	0	1	0	1	1
 *1	1	1	0	1	1
 *미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여
 *(N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 *
 *위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 *입력
 *첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
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
 *출력
 *첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
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

		int[] x = new int[size];		//x좌표
		int[] y = new int[size];		//y좌표
		int[] len = new int[size];	//누적거리
		
		//시작
		x[0] = 0;
		y[0] = 0;
		len[0] = cnt;
		
		while(pos < size && (x[pos] != height-1 || y[pos] != width-1)) {
			//지나갔음을 표시
			maze[x[pos]][y[pos]] = 0;
			
			//아래 확인
			if(x[pos]+1 < height && maze[x[pos]+1][y[pos]] == 1) {
				x[cnt] = x[pos] + 1;
				y[cnt] = y[pos];
				len[cnt] = len[pos]+1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//오른쪽 확인
			if(y[pos]+1 < width && maze[x[pos]][y[pos]+1] == 1) {
				x[cnt] = x[pos];
				y[cnt] = y[pos]+1;
				len[cnt] = len[pos]+1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//위 확인
			if(x[pos]-1 >= 0 && maze[x[pos]-1][y[pos]] == 1) {
				x[cnt] = x[pos] - 1;
				y[cnt] = y[pos];
				len[cnt] = len[pos] + 1;
				maze[x[cnt]][y[cnt]] = 0;
				cnt++;
			}
			
			//왼쪽확인
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
