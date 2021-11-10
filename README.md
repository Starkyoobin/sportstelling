sportstelling
=============
### 💪 skills 💪
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

### 🧾 포트폴리오 🧾
[Sportstelling 포트폴리오](https://github.com/Starkyoobin/sportstelling/blob/develop/Sportstelling.pdf)

### 💻 Project 설명 💻
Sportstelling은 **스포츠 커뮤니티 사이트**입니다. 스포츠활동을 공유하고 스포츠에 대한 궁금증을 풀며 건강한 스포츠활동을 생활화했으면 좋겠습니다.

### 📝 기획 및 설계 📝
- **UI 기획**  
https://ovenapp.io/project/uVAIVEtjudz5TcbYhbhdu3WFsAYgffRq#qoavO
- **DB, URL, 일정 설계**  
https://docs.google.com/spreadsheets/d/1x_pGcri3MjROVT6lBoW3v1NM0yjyxMhDhiYOBnoqne8/edit#gid=0

### 🖥 미리보기 🖥
- 로그인 및 회원가입

### 🔧 기능 🔧
- 회원가입, 로그인
  - package : [com.sportstelling.user.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/user)
  - view : [/webapp/WEB-INF/jsp/user/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/sign)
- 스포츠피드 이미지 첨부 글 작성
  - package : [com.sportstelling.sportsfeed.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/sportsfeed)
  - view : [/webapp/WEB-INF/jsp/main/sportsfeed/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/sportsfeed)
- 스포츠피드 좋아요
  - package : [com.sportstelling.sportsfeed.like.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/sportsfeed/like)
  - view : [/webapp/WEB-INF/jsp/main/sportsfeed/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/sportsfeed)\
- 스포츠Q&A 게시물 작성
  - package : [com.sportstelling.sportqna.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/sportsqna)
  - view : [/webapp/WEB-INF/jsp/main/sportsqna/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/sportsqna)
- 스포츠Q&A 게시물 댓글 작성
  - package : [com.sportstelling.sportsqna.comment.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/sportsqna/comment)
  - view : [/webapp/WEB-INF/jsp/main/sportsqna/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/sportsqna)
- 자유게시판 게시물 작성
  - package : [com.sportstelling.freepost.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/freepost)
  - view : [/webapp/WEB-INF/jsp/main/freepost/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/freepost)
- 자유게시판 게시물 댓글 작성
  - package : [com.sportstelling.sportsqna.comment.*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/java/com/sportstelling/freepost/comment)
  - view : [/webapp/WEB-INF/jsp/main/sportsqna/*](https://github.com/Starkyoobin/sportstelling/tree/develop/src/main/webapp/WEB-INF/jsp/main/freepost)

### 🔗 외부 라이브러리 라이센스 🔗 

* Tomcat [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 
* Mysql [GPLv2 or proprietary](https://www.gnu.org/licenses/gpl-3.0.html)
* Spring framework [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)  
* Mybatis [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
* Bootstrap [MIT License](https://opensource.org/licenses/MIT)
* jQuery [MIT License](https://opensource.org/licenses/MIT)
* 이미지 출처 : [pixabay](https://pixabay.com/ko/)

### 📝 향후 계획
- 회원탈퇴
- 이미지 미리보기
- 여러 이미지 업로드
- 로그인 보안성 강화 (Spring Security)
- 오픈API 데이터 사용 (RestTemplate 활용)
  - Spring Boot Scheduler
  - Batch Schduler
