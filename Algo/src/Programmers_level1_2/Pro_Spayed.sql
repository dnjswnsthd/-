-- ���α׷��ӽ� �ڵ��׽�Ʈ ���� �߼�ȭ ���� �ľ��ϱ�

SELECT ANIMAL_ID, NAME, CASE WHEN (SEX_UPON_INTAKE LIKE '%NEUTERED%' OR SEX_UPON_INTAKE LIKE '%SPAYED%') THEN 'O' ELSE 'X' END AS '�߼�ȭ'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC