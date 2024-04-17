from collections import deque


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        # We are bascially checking if there is a cycle in the graph.
        # If there is a cycle, then at least one of the nodes cannot be visited
        # If there are no cycles then all nodes can be visited
        # and if all of the nodes ARE visited then it is possible to finish all courses
        graph = [[] for courseIndex in range(numCourses)]
        edges = numCourses * [0]
        result = []

        # Create the graph by adding the [course, prerequisite] from prerequisites
        # also add the edges array to keep track of prerequisites
        for pairs in prerequisites:
            course = pairs[0]
            prerequisite = pairs[1]
            graph[prerequisite].append(course)
            edges[course] += 1

        # Kahn's algorithm with queue
        # We sort starting with a starting node with no incoming edges 
        # if node has no edges we add them into the queue
        # we remove the node's edges(dependencies) and move on to the next node where the current directs to
        # we add the node into the topological order result array after processing it before moving on to the next node
        # When we add the node into topological order result we also decreases the number of edges that are directed by the node we ad
        # Until we finish processing all nodes or there is a cycle
        # If length of result != numCourses, there is a cycle return false otherwise return true
        queue = deque()
        for i in range(numCourses):
            if edges[i] == 0:
                queue.append(i)

        while queue:
            current = queue.popleft()
            result.append(current)

            for nextCourse in graph[current]:
                edges[nextCourse] -= 1
                if edges[nextCourse] == 0:
                    queue.append(nextCourse)
            
        return len(result) == numCourses