# DFS, BFS, combination, permutation, powerSet, Dijkstra

review in 2022.02.26

## DFS (깊이 우선 탐색 Depth First Search)

0. 준비물: boolean[] visit, int[][] d
1. 방문하지 않은 모든 경우의 수를 for 문으로 확인한다.
2. 주어지는 i,j에 상하좌우 4개의 방향을 방문했는 지 확인하는 nextI,nextJ 생성 (최대 index 넘어가는 지도 확인해야함)
3. 방문했으면 continue 아니면 visit ture 로 하고 그 DFS(nextI,nextJ) 로 이동 시킨다.

## BFS ( 너비 우선 탐색 Breadth-First Search)

0. 준비물: boolean[] visit, int[][] d, queue
1. queue q를 생성하고 q 에 시작 노드를 넣는다.
2. 종료 조건은 q.isEmpty() ==true)
3. q poll 하고 그 q를 기준으로 상하좌우를 방문했는 지 확인한다. (최대 index 넘어가는 지도 확인해야함)
4. 방문했으면 continue 방문하지 않았으면 visit 처리하고 q.offer()

## permutation (순열)

0. 준비물, n,r, visit, numList, originalList
1. n 개중에 r 개를 선택. nPr 에서 n과 r 선택
2. permutation(int cnt) 함수 호출
3. 만약 cnt == r 이면 리턴 조건을 건다.
4. 0부터 n-1까지 순회하면서 방문했으면 continue 아니면 visit[true] 로 두고 해당 위치(cnt)의 값을 설정해주고 다음 permu로 들어간다.

```java
numList[cnt]=originalList[i];
        permu(cnt+1);
```

## combination (조합)

0. 준비물: n,r, numList,originalList, start
1. n개 중에 r개를 선택
2. combi(cnt,start) 로 시작하고 cnt== r 일때 return 조건 넣어준다.
3. start부터 시작해서 cnt 위치의 값을 i로 넣어주는 for 문 만들고 다음 자리로 이동시키고 start를 i값으로 넣어준다.

```java
for(i=start;i<N;++i){
        numList[cnt]=OriginalList[i];
        combi(cnt+1,i);
        } 
```

## powerSet(부분집합)

0. 준비물: n, numList, visit
1. powerSet(int cnt)로 시작
2. cnt == N 이 되면 종료조건 걸어준다.
3. for문 걸어서 visit했으면 continue 걸어주고 해당 인덱스에 있는 원소를 추가하지 않은 powerSet, 추가한 powerSet 을 호출
```python
def powerSet(int cnt){
    if(cnt==N) return;
    
    for(int i=0;i<cnt;++i){
        if(visit[i]) continue;
        powerSet(cnt+1);
        numList.append(numList[i]);
        visit[i] = true;
        powerSet(cnt+1);
    }
}

```


## Dijkstra

0. 준비물: pq, distance[],ArrayList<Edge>[] adj, visit[], start 
1. 노드 간선 가중치 정보로 인접 리스트를 만들고, weight 기준으로 정렬하는 Edge class 를 만든다. (생성자 Edge(int destination,int weight))
2. 거리 정보를 알고싶은 노드의 값은 0, 시작 노드 외 distance 배열을 INF 로 만든다.
3. pq에 adj[start] 값을 넣어준다.
4. while(!pq.isEmpty()),
5. Edge e = pq.poll(); 로 거리 값이 가장 작은 Edge를 가져온다.
6. 그 Edge의 destination과 weight 으로 비교해본다.
```Java

for(Edge next: adj[current]){
    if(visit[next.destination]) continue;
    visit[next.destination] = true;
    if(distance[next.destination] > distance[e.destination] + next.weight ){
        distance[next.destination] = distance[e.destination] + next.weight;
        pq.add(new Edge(next.destination, distance[next.destination]));
        }
    }
```