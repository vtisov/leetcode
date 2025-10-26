// https://leetcode.com/problems/cheapest-flights-within-k-stops/

public class CheapestFlightsWithinKStops {
  
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            System.arraycopy(dist, 0, temp, 0, n);
            for (int[] flight: flights) {
                if (dist[flight[0]] == Integer.MAX_VALUE) continue;
                temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
