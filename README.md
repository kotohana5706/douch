# D'ouch

## 팀원

  * 안준혁 - Client + Server 개발
  * 조재건 - 기획 및 구성 + Client 개발
  * 김민   - Client 디자인 및 구성


## Behind Story

1. 온가족이 모이는 가족의 저녁 식사에서 휴대폰만 쳐다보는 동생이 모습이 안타까웠습니다.
2. 생일 파티에서 모두 휴대폰만 봐서 비참한 기분 이였다.
3. 아이디어가 필요한 조별 프로젝트에서 모두 휴대폰만 봐서 프로젝트가 망했습니다.
4. 스터디 그룹에서 모두 휴대폰만 봐서 결국 놀기만 하고 공부를 할수 없었다.
5. 놀러가서 모두 핸드폰만 봐서 따돌려진 느낌이 들었다.


## Application 만든 이유

 * 휴대폰 사용을 통제하여 모임의 효율을 높인다.
 
우리가 모여서 학습이나 여가시간을 가질때 휴대폰 사용으로 인해 소통이 방해 받는 경우가 많습니다.
이 문제를 해결하기 위해 모임 시간과 장소에서 휴대폰의 기능을 제한 하여 소통...

약속 장소에서 지나친 휴대폰 사용은 모임의 목표 달성을 방해하며, 소통을 줄어들게 하여 모임의 분위기를 저하 시킨다.
우리는 최소한 약속 장소에서라도 휴대폰 사용을 막아서 모임에 집중할 수 있도록 하고자 하였다.


## Application 의 기능

 * 휴대폰 잠금 기능
   * lockscreen과 동일한 휴대폰 잠금 기능.
   * Application의 선별적 실행 기능.
   * 특정 거리 이상 장소 이탈 시 자동으로 unlock.
 * 모임 장소 및 일정 관리 기능.
   * 모임, 스터디그룹, 회의등의 일정을 잡는 기능.
   * 자주 모이는 사람들의 그룹을 유지.
   * 모임 전 모임에 대한 정보 알림.
   * 모임 참여 선택 기능.
   * 모임의 시간순 정렬 기능.


## Application의 디자인 

 * 디자인의 컨셉
   * 사계절을 기본 디자인
   * 계절에 따라 바뀌는 배경 이미지.
 * Android Material Design guidline 준수
 * Pencil을 사용한 Prototyping.
 * IEC 417 국제 표준을 준수하는 Power symbol을 사용한 Icon 제작.


## Application의 기술

 * Client 개발
   * Marterial ViewPager Library 사용.
   * Roboto & NotoSans font 사용.
   * Local data를 위한 SQLite3 사용
   * NFC와 GPS를 사용한 휴대폰 잠금 기능.
   * Lockscreen을 구현을 위한 Android Intent Hooking.
 * Server 개발
   * Server 구현을 위해 Node.JS + Mongo DB
   * 다양한 Node Module 사용
 * 개발 도구
   * 협업 도구로 Github와 Git을 사용.
   * Android Studio를 이용한 Java 개발
   * Gradle 을 이용한 Build system


## Application 개발 History

 1. Application의 주제 발굴
 2. Feature 확정
 3. User Scenario별 Story board 작성
 4. Story board 기반 Design
 5. Story board 기반 Program Software 개발


## 발표 준비

 * Behind 영상
 * Application 만든 이유
 * 팀원 소개
 * Application 기능 소개
 * Application 기술 소개
 * Application 디자인 소개
 * 개발과정 소개
 * 질의 응답
