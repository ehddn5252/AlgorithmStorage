import copy
def solution(dist):
    ans = []
    # 0. 사이즈가 점의 개수와 같은 array를 하나 만든다.
    # 1. 거리가 가장 큰 것을 찾는다.
    # 2. 그것을 양 끝에 넣는다.

    max = 0
    start=0
    end=0
    # 시간복잡도 100 * 100
    for i,innerList in enumerate(dist):
        for j, innerValue in enumerate(innerList):

            if innerValue>max:
                max=innerValue
                if(i>j):
                    start=j
                    end=i
                else:
                    start=i
                    end=j

    newList = copy.deepcopy(dist[start])
    print(newList)
    newListList =[]

    for i,v in enumerate(newList):
        newListList.append([i,v])

    newListList.sort(key=lambda x:x[1])
    pos=[start]

    for i,v in enumerate(newListList):
        if i==0 or i==len(newListList)-1:
            continue
        pos.append(v[0])
    pos.append(end)
    ans.append(pos)

    ans.append(list(reversed(pos)))
    return ans