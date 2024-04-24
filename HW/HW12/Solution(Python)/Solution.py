class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        # Krushal algorithm to find MST
        # Result list
        result = list(range(n+1))

        # find utilizing path compression
        def find (i):
            if result[i] != i:
                result[i] = find(result[i])
            return result[i]
        
        # Union but without implementing ranking
        def union(x, y):
            n1 = find(x)
            n2 = find(y)

            if n1 != n2:
                result[n2] = n1
                return True

            return False

        # Build graph with (weight, source, destination)
        edges = []

        # Put wells in graph i = houses/(wells if build), c = cost of building the well in house i
        # cost, i = source, n = dummy destination to even element count in list
        # enumerate creates well list
        for i, c in enumerate(wells):
            edges.append((c,i,n))

        # Add edges in graph
        # cost, u-1 , v-1 (-1 due to 0 indexing)
        for u, v, c in pipes:
            edges.append((c, u-1, v-1))

        # Sort the graph before building mst according to Krushal algorithm
        edges.sort()
        # minimum cost output
        cost = 0
        for c, u, v in edges:
            if union (u, v):
                cost += c
        
        return cost
            
