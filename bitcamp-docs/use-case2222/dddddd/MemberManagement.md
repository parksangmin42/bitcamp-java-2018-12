# UC001 - 스터디 가입 승인/거절(Member Management)
스터디에 가입신청한 회원을 승인/거절하는 것

## 주 액터(Primary Actor)

회원 - 스터디장

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)

회원이 해당 스터디에 스터디 가입 신청을 작성한 상태여야 한다.

## 종료 조건(Postconditions)

- 스터디 가입을 승인하였다.
- 스터디 가입을 거절하였다.

## 시나리오(Flow of Events)

### 스터디 가입 승인

1. 액터는 가입신청 관리 버튼을 클릭한다.
2. 시스템은 가입신청한 회원의 목록을 출력한다.
    - 가입신청한 회원이 없다면,
        - 신청한 회원이 없다는 문구를 출력한다.
3. 액터는 목록에서 가입한 회원의 정보를 클릭한다.
4. 시스템은 가입신청한 회원의 정보(회원의 평점, 신청내용)를 출력한다.
    - 가입 신청한 회원이 평점 데이터가 없다면,
        - 기본 평점값과 신청내용만 출력한다.
5. 액터는 가입 승인 버튼을 클릭한다.
6. 시스템은 해당 회원을 스터디에 가입시키고 MyStudy 페이지를 출력한다.


### 스터디 가입 거절

1. 액터는 가입신청 관리 버튼을 클릭한다.
2. 시스템은 가입신청한 회원의 목록을 출력한다.
    - 가입신청한 회원이 없다면,
        - 신청한 회원이 없다는 문구를 출력한다.
3. 액터는 목록에서 가입한 회원의 정보를 클릭한다.
4. 시스테은 가입신청한 회원의 정보(회원의 평점, 신청내용)를 출력한다.
    - 가입 신청한 회원이 평점 데이터가 없다면,
        - 기본 평점값과 신청내용만 출력한다.
5. 액터는 가입 거절 버튼을 클릭한다.
6. 시스템은 해당 회원에게 가입 거절 알림을 출력시키고 MyStudy 페이지를 출력한다.


## UI 프로토타입
### 가입신청 관리



 

