select * from tab;
select * from emp;
select  distinct job from emp;
--�ʵ���� �ܵ����� �����
--�ּ���

select ename, sal from emp;
--�巡���ؼ� ���ഩ���� �ش� ���๮�� �����
--Ŀ���� �ִ� ������ ��Ʈ�ѿ���->����

--���ʽ��� �����ʴ� ����� �����϶�
select * from emp where comm = null;
--����ȵ� null �� = �̷��� �񱳾ȵ�
select * from emp where comm is null;
select * from emp where comm is not null;
select * from emp where comm is null or comm=0;

--�Ի����� 80�⵵�� ����� ���϶�
select * from emp where hiredate like '80%';
--2���� �Ի��� ����� �����϶�
select * from emp where hiredate like'___02%';

--NVL() : null  �����͸� �ٸ������� �����Ͽ� ó���ϴ� �Լ��� �ִ�.
--NVL(�ʵ��,������) �ʵ���� �������̸� �̷����� ��� �� 
select ename, sal, comm, NVL(comm,0)+100 "�� �� ��" from emp;

-- emp ���̺��� ����� �����϶�.
-- �ʵ�� �����, ������, �޿�, ���ʽ�, ���޾��� �����Ѵ�
--���ʽ��� null�� ��� 0���� ǥ�� 
--���޾��� ���ʽ�+�޿��̴�.
select ename, job, sal, NVL(comm,0) ���ʽ�, sal + nvl(comm,0) ���޾� from emp;

--�̷��� ������ ���������
select ename || ' ' || ' AS A ' || job || '.' msg from emp;

select ename || ':' || '1 YEAR SALARY =' || sal*12 list from emp; 

--���� (order by) where,from �� ������
--�̸������� �����϶� /�⺻���� �������� ����
select * from emp order by ename asc;
--������������
select * from emp order by ename desc;

--�μ��� �޿������� �����϶�.
select * from emp order by job asc, sal asc;
--job�� ���� �����ϰ� ���� job���� �ȿ��� sal����

--emp���̺��� ����� �������� �繫��, �Ŵ����� ����� �Ի��� ������ �����϶�
--�� �ʵ�� �����, ������, �Ի���, �޿��� ���� 

select ename, job, hiredate, sal from emp where job in('MANAGER','CLERK') order by hiredate;

--emp ���̺��� ���ʽ��� ���� �ʴ� ����� �����ȣ, �����, �޿�, ���ʽ��� �޿��� ���������� �����϶�.
select empno, ename, sal, comm from emp
where comm is null or comm=0
order by sal desc;


--(��������)
--1
select empno, ename, sal from emp;

--2
select empno, ename, sal, job from emp order by ename asc;

--3
select * from emp where hiredate like'___05%';

--4 A���Ի�� �޿� 3000�̻� �������
select * from emp where ename like '%A%' or sal>=3000;

--5
select * from emp where job='SALESMAN' or job='MANAGER';

--6
select * from emp where sal>=3000 and (comm is null or comm=0);

--7
select * from emp 
where sal between 2000 and 4000 or comm>0 order by sal desc;

--8
select * from tab;
select * from tabs;
--tabs�� �� ���� ������ ����

--9
select empno, ename, job, hiredate, sal
from emp
where deptno = 10 or deptno=20
order by job asc, sal desc;

select * from tab;
select abs(-1234) from dual; --dual�̶�� ���� ���̺��� ����ϸ�ȴ� -�� ���� �ʵ�ϱ�
select abs (-1234)"absolute" from dual;
select abs (sal) from sal;

-- sal�� db �� �ִ� �ʵ�ϱ� ���̺�ȿ� �Ǽ��������ϱ� ������°�
--�ø�(ceil) : ���� ������ ū ���� 
--����(floor) : ���� �� ���� ���� ����

select ceil(15.1),floor(15.9) from dual;

--�ݿø�(round) : ���簪�� �ݿø�
--round(n),        round(n,m)([]) ���ȣ�� �ʿ������ ������� 
--                  m�� �Ҽ������� ǥ�õǴ� �ڸ���, �ݿø���ġ�� m+1���� �ݿø� �ȴ�.
select round(56.7), round(56.72989,1) from dual; --�Ҽ����� ���ڸ�����������,56.72989,2(�Ҽ����� ���ڸ���������)

--������ ���ϱ� �޿��� 1000���� ���� �������� ���Ͽ��� �ڹٿ����� %
select mod(sal,1000) from emp; 
-- �ŵ����� 3�� 4�� ���Ѵٴ� �� 
select power(3,4) from dual;
-- turnc(); ����              �����κ� ù��° �ڸ��� ����
select trunc(53.1542,2),trunc(53.1542,-1) from dual;


--���ڿ� �Լ� 
-- concat():���ڿ� ���� ename������ emp�� ���°Ŵ�.
select concat(ename,'��')����� from emp;

--initcap() : ���ܾ��� ù��° ���ڸ� �빮�ڷ� ��ȯ
select initcap('inicap string test')from dual;
--lower():���δ� �ҹ��ڷ� ��ȯ
select lower (ename) from emp;

--upper():���δ� �빮�ڷ� ��ȯ
select upper ('upper string test') from dual;

--LPAD() : ���� ���� �ڸ��� ���ϴ� ���ڸ� ǥ��
--RPAD() : ���� ������ �ڸ��� ���ϴ� ���ڸ� ǥ��
select lpad(ename,10,'*'),rpad(ename,10,'$') from emp;

--substr():�Ϻ� ���ڿ� ���ϱ�
select job ,substr(job,2,3), substr(job,-3,2)from emp;

--length() : ���ڼ�
select ename, length(ename) from emp;
select length('ȫ�浿')from dual; --����

--replace : Ư�����ڸ� �ٸ� ���ڷ� ġȯ�Ѵ�.
select ename, replace(ename,'A',' ����')from emp;
--�̸��� ���ڱ����� 50���θ�ŭ ����ϰ� �������� ���� *�� ����ض�)
select ename,lpad(ename,5,'*')from emp;--�����Ѱ� \
--select ename, rpad(substr(ename,1,ceil(length(ename/2)),length(ename),'*')"rapd" from emp;
--select enmae, rpad(substr(ename,1,floor(length(ename)/2)), length(ename),'*') "rapd" from emp;
select rpad(substr(ename, 1, ceil(length(ename)/2)), length(ename), '*') from emp;--�������

--instr : Ư�������� ��ġ���ϱ� , ������ 0
select job, instr(job,'S')from emp;
select job, instr(job,'S',3) from emp;
-- ANALYST  �ι�° A�� ������ ������ �ι�° A�� ���⶧���� 0�̳���
SELECT JOB, INSTR(JOB,'A',2,2)FROM EMP;

--�̸����� �̿��Ͽ� ���̵�� �������� �и��Ǿ��.
--@ �������� �Ǿ �����̶� �������� �и��Ǿ�� �Ǵµ�
     select concat('lyh4671','@naver.com') from dual; -- concat�� ��ġ�°Ŵϱ� @�� �������� ����Ʈ�� ������Ǵ°ǵ� �ȵǳ�;
     select sub('lyh4671','@naver.com') from dual;




--trim : Ư������ �����ϱ�
select * from emp;
select trim('S' from ename), ename from emp;
select trim('N' from ename), ename from emp;
select sal, trim(0 from sal) from emp;

--LTrim : ���ʹ��� ����
select ltrim('xyxxyZXTestxyxxy', 'xy') from dual;
--RTrim : �����ʹ�������
select job,rtrim(job,'GER') from emp;

select empno, ename, job, hiredate, sal, comm, sal+nvl(comm+0) ���޾�
from emp;
select empno, ename, job, hiredate, sal, comm, sal+comm ���޾�
from emp;

select ename, job, sal, nvl(comm,0) ���ʽ� from emp
where sal between 2500 and 4000 or job=upper('salesman')
order by sal desc;

--decode : if��
-- 10:�ѹ���, 20:�λ�� 30:��ȹ��

select ename, deptno, decode(deptno, 10, '�ѹ���', 20, '�λ��',30,'��ȹ��') �μ��� from emp;

--��������� ���� ��¥������ ���
--��¥ -> ����   toChar()
--���� -> ��¥   toDate()

select abs(sal) from emp;



