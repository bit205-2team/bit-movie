select * from tab;
select * from emp;
select  distinct job from emp;
--필드명을 단독으로 써야함
--주석문

select ename, sal from emp;
--드래그해서 실행누르면 해당 실행문이 실행됨
--커서가 있는 곳에서 컨트롤엔터->실행

--보너스를 받지않는 사원을 선택하라
select * from emp where comm = null;
--실행안됨 null 은 = 이렇게 비교안됨
select * from emp where comm is null;
select * from emp where comm is not null;
select * from emp where comm is null or comm=0;

--입사일이 80년도인 사람을 구하라
select * from emp where hiredate like '80%';
--2월에 입사한 사원을 선택하라
select * from emp where hiredate like'___02%';

--NVL() : null  데이터를 다른값으로 변경하여 처리하는 함수가 있다.
--NVL(필드명,지정값) 필드명이 지정값이면 이렇게해 라는 뜻 
select ename, sal, comm, NVL(comm,0)+100 "보 너 스" from emp;

-- emp 테이블의 사원을 선택하라.
-- 필드는 사원명, 담당업무, 급여, 보너스, 지급액을 선택한다
--보너스는 null인 경우 0으로 표시 
--지급액은 보너스+급여이다.
select ename, job, sal, NVL(comm,0) 보너스, sal + nvl(comm,0) 지급액 from emp;

--이렇게 문장을 만들수있음
select ename || ' ' || ' AS A ' || job || '.' msg from emp;

select ename || ':' || '1 YEAR SALARY =' || sal*12 list from emp; 

--정렬 (order by) where,from 절 다음에
--이름순으로 선택하라 /기본으로 오름차순 정렬
select * from emp order by ename asc;
--내림차순정렬
select * from emp order by ename desc;

--부서별 급여순으로 정렬하라.
select * from emp order by job asc, sal asc;
--job를 먼저 정렬하고 같은 job범위 안에서 sal정렬

--emp테이블의 사원중 담당업무가 사무직, 매니저인 사원의 입사일 순으로 선택하라
--단 필드는 사원명, 담당업무, 입사일, 급여를 선택 

select ename, job, hiredate, sal from emp where job in('MANAGER','CLERK') order by hiredate;

--emp 테이블에서 보너스를 받지 않는 사원의 사원번호, 사원명, 급여, 보너스를 급여가 높은순으로 선택하라.
select empno, ename, sal, comm from emp
where comm is null or comm=0
order by sal desc;


--(연습문제)
--1
select empno, ename, sal from emp;

--2
select empno, ename, sal, job from emp order by ename asc;

--3
select * from emp where hiredate like'___05%';

--4 A포함사원 급여 3000이상 사원선택
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
--tabs는 더 많은 정보가 보임

--9
select empno, ename, job, hiredate, sal
from emp
where deptno = 10 or deptno=20
order by job asc, sal desc;

select * from tab;
select abs(-1234) from dual; --dual이라는 가상 테이블을 사용하면된다 -가 없는 필드니까
select abs (-1234)"absolute" from dual;
select abs (sal) from sal;

-- sal은 db 에 있는 필드니깐 테이블안에 실수가없으니깐 상수쓰는거
--올림(ceil) : 현재 값보다 큰 정수 
--버림(floor) : 현재 값 보다 작은 정수

select ceil(15.1),floor(15.9) from dual;

--반올림(round) : 현재값의 반올림
--round(n),        round(n,m)([]) 대괄호는 필요없으면 실행안함 
--                  m은 소수이하의 표시되는 자릿수, 반올림위치는 m+1에서 반올림 된다.
select round(56.7), round(56.72989,1) from dual; --소수이하 한자리수까지보여,56.72989,2(소수이하 두자리까지보여)

--나머지 구하기 급여를 1000으로 나눈 나머지를 구하여라 자바에서는 %
select mod(sal,1000) from emp; 
-- 거듭제곱 3을 4번 곱한다는 뜻 
select power(3,4) from dual;
-- turnc(); 버림              정수부분 첫번째 자리를 버림
select trunc(53.1542,2),trunc(53.1542,-1) from dual;


--문자열 함수 
-- concat():문자열 연결 ename때문에 emp를 쓰는거다.
select concat(ename,'님')사원명 from emp;

--initcap() : 각단어의 첫번째 문자를 대문자로 변환
select initcap('inicap string test')from dual;
--lower():전부다 소문자로 변환
select lower (ename) from emp;

--upper():전부다 대문자로 변환
select upper ('upper string test') from dual;

--LPAD() : 남은 왼쪽 자리에 원하는 문자를 표시
--RPAD() : 남은 오른쪽 자리에 원하는 문자를 표시
select lpad(ename,10,'*'),rpad(ename,10,'$') from emp;

--substr():일부 문자열 구하기
select job ,substr(job,2,3), substr(job,-3,2)from emp;

--length() : 문자수
select ename, length(ename) from emp;
select length('홍길동')from dual; --글자

--replace : 특정문자를 다른 문자로 치환한다.
select ename, replace(ename,'A',' 에이')from emp;
--이름을 글자길이의 50프로만큼 출력하고 나머지는 문자 *로 출력해라)
select ename,lpad(ename,5,'*')from emp;--내가한거 \
--select ename, rpad(substr(ename,1,ceil(length(ename/2)),length(ename),'*')"rapd" from emp;
--select enmae, rpad(substr(ename,1,floor(length(ename)/2)), length(ename),'*') "rapd" from emp;
select rpad(substr(ename, 1, ceil(length(ename)/2)), length(ename), '*') from emp;--희수정답

--instr : 특정문자의 위치구하기 , 없으면 0
select job, instr(job,'S')from emp;
select job, instr(job,'S',3) from emp;
-- ANALYST  두번째 A는 있지만 끝에서 두번째 A가 없기때문에 0이나옴
SELECT JOB, INSTR(JOB,'A',2,2)FROM EMP;

--이메일을 이용하여 아이디와 도메인이 분리되어라.
--@ 기준점이 되어서 메일이랑 도메인이 분리되어야 되는데
     select concat('lyh4671','@naver.com') from dual; -- concat이 합치는거니깐 @를 기준으로 떨어트려 놓으면되는건데 안되네;
     select sub('lyh4671','@naver.com') from dual;




--trim : 특정문자 제거하기
select * from emp;
select trim('S' from ename), ename from emp;
select trim('N' from ename), ename from emp;
select sal, trim(0 from sal) from emp;

--LTrim : 왼쪽문자 제거
select ltrim('xyxxyZXTestxyxxy', 'xy') from dual;
--RTrim : 오른쪽문자제거
select job,rtrim(job,'GER') from emp;

select empno, ename, job, hiredate, sal, comm, sal+nvl(comm+0) 지급액
from emp;
select empno, ename, job, hiredate, sal, comm, sal+comm 지급액
from emp;

select ename, job, sal, nvl(comm,0) 보너스 from emp
where sal between 2500 and 4000 or job=upper('salesman')
order by sal desc;

--decode : if문
-- 10:총무부, 20:인사부 30:기획부

select ename, deptno, decode(deptno, 10, '총무부', 20, '인사부',30,'기획부') 부서명 from emp;

--생년월일은 보통 날짜형으로 담김
--날짜 -> 문자   toChar()
--문자 -> 날짜   toDate()

select abs(sal) from emp;



