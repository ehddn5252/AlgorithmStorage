-- 코드를 입력하세요
-- 캐릭터 테이블에 있는 모든 캐릭터에 대해 캐릭터의 이름과 해당 캐릭터가 구입한 횟수를 조회하는 쿼리 작성하기
select NAME, IFNULL((select count(item) from purchases group by item having name=item),0) as CNT
from characters


