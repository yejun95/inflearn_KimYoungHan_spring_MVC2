- 인프런 김영한님의 MVC2 강의 기록을 위한 repo
<br>

## ✔️ thymeleaf-basic directory
**학습 범위 : 5-1-1 - 5-1-19**
- 타임리프 소개
- 텍스트 - text, utext
- 변수 - SpringEL
- 기본 객체들
- 유틸리티 객체와 날짜
- URL 링크
- 리터럴
- 연산
- 속성 값 설정
- 반복
- 조건부 평가
- block 태그
- 자바스크립트 인라인
- 템플릿 조각 - fragment
- 템플릿 레이아웃1
- 템플릿 레이아웃2
<br>
<hr>
<br>

## ✔️ form directory
**학습 범위 : 5-2-1 - 5-2-10**
- th:object
- th:field
- single checkbox
- multi checkbox
- radio button
- select box
<br>

**중점 학습 내용**
- form 태그 안에서 th:object 및 th:field를 이용한 데이터 조회, 전송

- spring에서 @ModelAttribute를 전역으로 설정하여 어느 api 호출이던지 데이터 받아오기
<br>
<hr>
<br>

## ✔️ message directory
**학습 범위 : 5-3-1 - 5-3-7**
- message 국제화
- message_properties
- message_en.properties

**중점 학습 내용**
- Locale 별 유연한 변경을 위한 국제화 적용
- 타임리프에서 `th:text=#{}` 기능 활용
<br>
<hr>
<br>

## ✔️ validation directory
**학습 범위 : 5-4-1 - 5-5-14**
- 서버-클라이언트간 validation 점진적 변화 확인
- Map으로 errors를 직접 담아 처리
- BindingResult에 객체 담아 에러 처리
  - error의 properties 설정
  - addError
  - rejectValue
  - MessageCodesResolver
  - level 단위로 나눈 에러 메세지
<br>

- validator 분리
  - validator
  - WebDataBinder
  - @Validated, @Valid
<br>

- Been Validation
  - groups : 동일 객체에 다른 validation을 주는 경우
  - 폼 전송 모델 객체 별도 생성
<br>
<hr>
<br>

## ✔️ login directory
**학습 범위 : 5-6-1 - 5-7-8**
- 로그인 기능
- 쿠키와 세션
- 세션 정보와 타임아웃 설정
- Filter
  - Log Filter
  - 인증 체크 필터
  - white list
<br>

- Interceptor
  - Log Interceptor
  - Login Interceptor
  - ArgumentResolver (Login 세션 체크를 Annotation으로 처리)
<br>
<hr>
<br>

## ✔️ exception directory
**학습 범위 : 5-8-1 - 5-9-9**
- servlet 예외 처리
  - WebServerCostomizer
  - DispatcherType - filter 중복 호출 방지
<br>

- spring interceptor 중복 처리 방지
  - excludePathPatterns에 에러페이지 경로를 직접 넣음
<br>

- springBoot 오류페이지 자동 찾기
  - BasicErrorController
<br>

- api 예외 처리
  - HTML을 반환할 때
  - JSON을 반환할 때
<br>

- HandlerExceptionResolver : BasicController의 상위 호환급
  - BasicController 보다 더 세밀하고 복잡하게 짤 수 있음 (HTML을 반환 시에 편한 방법임)
  - 에러 응답이 WAS까지 넘어가지 않아서 필터, 인터셉트가 중복으로 호출되지 않음
<br>

- Spring이 제공하는 Exception Resolver
  - 기존 보다 로직을 손쉽게 처리 가능
  - ResponseStatusExceptionResolver
  - DefaultHandlerExceptionResolver : Spring이 내부에서 기본적으로 처리해주는 예외 처리 (자동)
  - ExceptionHandlerExceptionResolver : 중요! -> @ExceptionHandler로 사용, 3가지 중 우선 순위가 제일 높다.
<br>

- @ControllerAdvice, @RestControllerAdvice
  - controller에서 호출되는 에러를 한곳에러 처리 가능하게함
  - controller 대상 컨트롤러 지정/미지정 가능
    - controller / RestController
    - 패키지 범위
    - 특정 클래스
<br>
<hr>
<br>

## ✔️ typeconverter directory
**학습 범위 : 5-10-1 - 5-10-11**
- 💡 해당 학습에서 사용하는 converter와 JSON객체를 다루는 HttpMessageConverter는 다른 것!!

- converter 인터페이스 직접 구현

- DefaultConversionService : 기본 converter 및 직접 구현한 converter 추가 가능

- thymeleaf에 converter 적용한 것 출력하기

- Formatter
  - FormattingConversionService
  - DefaultFormattingConversionService -> converter와 formatter를 같이 쓸 수 있게함
<br>

- 스프링이 제공하는 기본 formatter
  - @NumberFormat
  - @DateTimeFormat
<br>
<hr>
<br>

## ✔️ upload directory
**학습 범위 : 5-11-1 - 5-11-7**
- controllerV1 : 서블릿과 파일업로드1
  - 파일 업로드 시 출력되는 로그 확인
<br>

- controllerV2 : 서블릿과 파일업로드2
  - 로컬에 저장
<br>

- SpringController : 스프링을 이용한 간단한 파일 업로드
<br>

- ItemController : 스프링을 이용한 파일 업로드 및 다운로드
  - 사용자 저장 파일 이름, 서버 저장 파일 이름을 구분
  - FileStore 클래스에 파일 관련 메서드 분리
