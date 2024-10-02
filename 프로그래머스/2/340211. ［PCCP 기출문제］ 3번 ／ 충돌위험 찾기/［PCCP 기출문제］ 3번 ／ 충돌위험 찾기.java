class Solution {
    class robot {
		int r, c, cur, nextr, nextc;

		public robot(int r, int c, int cur, int nextr, int nextc) {
			super();
			this.r = r;
			this.c = c;
			this.cur = cur;
			this.nextr = nextr;
			this.nextc = nextc;
		}
	}
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int size = routes.length;
        int s = size;
        int r = routes[0].length;
        robot[] robots = new robot[size];
        int[] invalid = new int[size];
        int[][] map = new int[101][101];
        robot ro;
        
        for (int i = 0; i < size; i++) {
        	int start = routes[i][0]-1;
        	int next = routes[i][1]-1;
        	ro = new robot(points[start][0], points[start][1], 1, points[next][0], points[next][1]);
        	robots[i] = ro;
        	map[ro.r][ro.c]++;
        }
        
        while (s > 0) {
        	for (int i = 1; i <= 100; i++) {
        		for (int j = 1; j <= 100; j++) {
        			if (map[i][j] > 1) {
        				answer++;
        			}
        		}
        	}
        	
        	for (int i = 0; i < size; i++) {
        		if (invalid[i] == 1) continue;
        		ro = robots[i];
        		if (ro.r == ro.nextr && ro.c == ro.nextc) {
        			ro.cur++;
        			if (ro.cur == r) {
        				s--;
        				map[ro.r][ro.c]--;
        				invalid[i] = 1;
        			}
        			else {
        				ro.nextr = points[routes[i][ro.cur]-1][0];
        				ro.nextc = points[routes[i][ro.cur]-1][1];
        			}
        		}
        		
        		map[ro.r][ro.c]--;
        		if (ro.r < ro.nextr) ro.r++;
        		else if (ro.r > ro.nextr) ro.r--;
        		else if (ro.c < ro.nextc) ro.c++;
        		else if (ro.c > ro.nextc) ro.c--;
        		
        		map[ro.r][ro.c]++;
        		
        	}
        }
        
        return answer;
    }
}