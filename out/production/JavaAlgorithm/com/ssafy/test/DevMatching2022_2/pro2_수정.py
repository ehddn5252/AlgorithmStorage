from itertools import product

import copy

visit = []
newGird = []
abcVisit = set()
def solution(grid):
    global visit
    global newGrid
    answer = 0
    d = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    # 모든 경우 다 해보기
    count = 0
    for i, innerList in enumerate(grid):
        visit.append([])
        for j, v in enumerate(innerList):
            visit[i].append(False)
            if v == '?':
                count += 1


    # 중복 순열 다 확인
    # a,b,c 라는 원소를 가진 길이 count 의 중복순열을 만들기
    for index, orderedPair in enumerate(product(['a', 'b', 'c'], repeat=count)):

        indexCount = 0
        newGrid = list(copy.deepcopy(grid))
        # grid 세팅 ? 를 세팅해준다
        # 물음표에 중복순열해서 나온 알파벳 리스트 값을 순서대로 집어 넣습니다.


        for j, innerList in enumerate(newGrid):
            for k, v in enumerate(innerList):
                visit[j][k] = False
                if (newGrid[j][k] == '?'):
                    # newGrid[j][k] = orderedPair[indexCount]
                    newGrid[j] = newGrid[j][:k] + orderedPair[indexCount] + newGrid[j][k + 1:]
                    indexCount += 1

        ### grid 세팅 끝

        newCount = 0
        breakFlag=False
        for nowI, innerList in enumerate(newGrid):
            for nowJ, v in enumerate(innerList):
                if (visit[nowI][nowJ] != True):
                    abcVisit.add(newGrid[nowI][nowJ])
                    newCount += 1
                    dfs(nowI, nowJ, d)
                    if newCount>3:
                        breakFlag=True
                        break
            if(breakFlag):
                break
        if newCount <= 3:
            if(len(abcVisit)==newCount):
                answer += 1

    return answer

def dfs(nowI, nowJ, d):
    global visit
    global newGrid
    for i in range(4):
        nextI = nowI + d[i][0]
        nextJ = nowJ + d[i][1]
        if (nextI >= 0 and nextI < len(newGrid) and nextJ >= 0 and nextJ < len(newGrid[0])):
            if (visit[nextI][nextJ] == False):
                if(newGrid[nowI][nowJ] == newGrid[nextI][nextJ]):

                    visit[nextI][nextJ] = True
                    dfs(nextI, nextJ, d)

grid=['??b','abc','a??']
solution(grid)