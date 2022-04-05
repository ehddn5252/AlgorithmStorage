-- 코드를 입력하세요
SELECT c_p.cart_id as CART_ID ,if(sum(price)>minimum_requirement,0,1) as abused
from Cart_products as c_p join coupons as c
where c_p.cart_id = c.cart_id
group by c_p.cart_id;

