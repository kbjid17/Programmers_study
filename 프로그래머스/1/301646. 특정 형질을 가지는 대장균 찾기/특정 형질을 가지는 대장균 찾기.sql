-- 코드를 작성해주세요


SELECT COUNT(*) AS COUNT FROM ECOLI_DATA
WHERE CONV(GENOTYPE,10,2) | b'0010' != CONV(GENOTYPE,10,2)
and (CONV(GENOTYPE,10,2) | b'0100'= CONV(GENOTYPE,10,2) 
or CONV(GENOTYPE,10,2) | b'0001'= CONV(GENOTYPE,10,2) );