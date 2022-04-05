def solution(dist):
    max = start = 0
    newListList =[]
    for i,innerList in enumerate(dist):
        for j, innerValue in enumerate(innerList):
            if innerValue>max:
                max=innerValue
                start=min(i,j)

    for i,v in enumerate(dist[start]):
        newListList.append([i,v])

    newListList.sort(key=lambda x:x[1])
    pos=list(map(lambda x:x[0],newListList))
    return [pos,list(reversed(pos))]

dist=[[0,1,1,1],[1,0,2,5],[1,2,0,3],[1,5,3,0]]
print(solution(dist))