# UC001 - 스터디 조회(Study List)
등록된 스터디를 조회하는 것

## 주 액터(Primary Actor)

비회원, 회원

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)

메인 홈페이지에서 원하는 카테고리를 찾아 클릭한다.
카테고리1
카테고리2
카테고리3
카테고리4
카테고리5
## 종료 조건(Postconditions)

- 원하는 스터디를 찾았다.
- 원하는 스터디를 찾지 못했다.

## 시나리오(Flow of Events)


### 스터디 조회하기   

1. 액터는 메인페이지에서 카테고리 1-5중 원하는 메뉴를 클릭한다.
2. 시스템은 해당 카테고리에 등록된 목록을 출력한다.
    - 해당 카테고리에 등록된 스터디가 존재하지 않는다면,
        - 시스템은 등록된 스터디가 없다는 내용을 출력한다.
3. 액터는 목록에서 원하는 스터디를 선택해 클릭한다.
4. 시스템은 선택된 스터디에 대해 상세 정보(스터디 제목, 스터디 설명, 전체평점, 스터디 활동량)을 출력한다.
    - 해당 상세 정보에서 스터디가 생성된지 얼마 안된 스터디라 활동량과 전체 평점이 없다면,
        - 시스템은 생성된지 얼마 안된 스터디임을 출력하고 기본 값으로 설정한 값을 출력해 보여준다.

## UI 프로토타입

### 스터디 목록

#### 대안 흐름(Alternaive Flows)

 - 1.1 액터는 원하는 카테고리가 없을 경우 검색창에 자신이 원하는 스터디를 검색한다.
 - 1.2 시스템은 해당 검색어를 키워드로 등록된 스터디의 목록을 출력한다.
 - 1.3 액터는 목록에서 원하는 스터디를 선택해 클릭한다.
 - 1.4 시스템은 선택된 스터디에 대해 상세 정보(스터디 제목, 스터디 설명, 전체평점, 스터디 활동량)을 출력한다.

