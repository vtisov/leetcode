// https://leetcode.com/problems/cheapest-flights-within-k-stops/

public class CheapestFlightsWithinKStops {
  
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      final int INF = Integer.MAX_VALUE;
      int[] dist = new int[n];
      Arrays.fill(dist, INF);
      dist[src] = 0;
  
      for (int i = 0; i <= k; i++) {
          int[] temp = new int[n];
          System.arraycopy(dist, 0, temp, 0, n);
          boolean updated = false;
  
          for (int[] flight : flights) {
              int u = flight[0], v = flight[1], w = flight[2];
              if (dist[u] == INF) continue;
              if (dist[u] + w < temp[v]) {
                  temp[v] = dist[u] + w;
                  updated = true;
              }
          }
          dist = temp;
          if (!updated) break;
      }
  
      // for (int[] flight : flights) { // no needs, because of k != n
      //     int u = flight[0], v = flight[1], w = flight[2];
      //     if (dist[u] != INF && dist[u] + w < dist[v]) {
      //         return -1;
      //     }
      // }
  
      return dist[dst] >= INF ? -1 : dist[dst];
  }

  /*
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
  */
  
}
