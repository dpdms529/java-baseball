## 기능 목록
- 게임 시작 문구 출력 : "숫자 야구 게임을 시작합니다."
- 게임 실행 상태가 시작(=1)이면 게임 시작 
  - 초기화
    - 결과 초기화
    - 문제 생성 : 1에서 9까지 서로 다른 임의의 수 3개 선택 
      - 임의의 수 선택 -> camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
      - 리스트에 선택된 수 저장
      - 3개 선택할 때까지 반복
  - 문제 풀기
    - 입력 요청 문구 출력 : "숫자를 입력해주세요 : "
    - 사용자로부터 서로 다른 3자리 수 입력 받기
      - 서로 다른 3자리 수 입력 받기 -> camp.nextstep.edu.missionutils.Console의 readLine() 사용 
      - 잘못된 값 입력받은 경우 IllegalArgumentException
        - 1~9사이의 수로 이루어진 3자리 수가 아닌 경우
        - 각 자리수가 서로 다르지 않을 경우
      - 리스트에 각 자리 수 저장
    - 입력한 수에 대한 결과 출력 
      - 각 자리 수 검사
        - 사용자가 선택한 수와 컴퓨터가 선택한 수가 동일한지 확인
        - 사용자가 선택한 수가 컴퓨터가 선택한 수 리스트에 존재하는지 확인
        - 결과 계산
          - 사용자가 선택한 수와 같은 자리에 있는 컴퓨터가 선택한 수가 동일하면 스트라이크 수 +1
          - 사용자가 선택한 수가 컴퓨터가 선택한 수 리스트에 존재하고 같은 자리에 있는 컴퓨터가 선택한 수와 다르면 볼 수 +1
      - 결과 생성
        - 볼 수 = 0 && 스트라이크 수 = 0 : reusltMessage = "낫싱"
        - 볼 수 > 0 && 스트라이크 수 = 0 : reusltMessage = "(볼 수)볼"
        - 볼 수 = 0 && 스트라이크 수 > 0 : reusltMessage = "(스트라이크 수)스트라이크"
        - 볼 수 > 0 && 스트라이크 수 > 0 : resultMessage = "(볼 수)볼 (스트라이크 수)스트라이크"
      - 결과 출력
    - 정답 여부 확인
      - 스크라이크 수가 3이면 게임 성공 문구 출력 : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
      - 스트라이크 수가 3미만이면 정답 맞추기 반복
  - 게임 다시 시작할지 종료할지 선택
    - 게임 재시작 여부 질문 문구 출력 : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    - 사용자로부터 입력 받기
      - 예외 처리 IllegalArgumentException
        - 1 또는 2가 아닌 경우
- 게임 실행 상태가 종료(=2)이면 게임 종료

## 클래스 설계
### Game
- problemMaker : ProblemMaker
- problemSolver : ProblemSolver
- result : Result
- status : String
- start()
- printStartMessage()
- isStartStatus() : boolean
- initialize
- solveProblem()
- checkAnswer()
- countResult()
- requestToRestart()
- getters & setters
### Player
- numbers : List\<Integer>
- getNumbers() : List\<Integer>
- setNumbers(List\<Integer> numbers)
- addNumber(int number)
- initialize()
### ProblemMaker
- extends Player
- makeProblem(int sizeOfNumbers)
- hasNumber(int number) : boolean
- isSameAtGivenLocation(int number, int index) : boolean
### ProblemSolver
- extends Player
- solveProblem(int sizeOfNumbers)
- checkValidAnswerInput(String answer, int sizeOfNumbers)
- chooseToRestart() : int
- checkValidRestartChoiceInput(String choice)
### Result
- ballCount : int
- strikeCount : int
- initialize()
- increaseBallCount()
- increaseStrikeCount()
- createResultMessage() : String
- isWrongAnswer() : boolean
- getters & setters
### Settings
- SIZE_OF_NUMBERS : int
- START_STATUS : String
- TERMINATE_STATUS : String
- START_MESSAGE : String
- ANSWER_REQUEST_MESSAGE : String
- SUCCESS_MESSAGE : String
- RESTART_REQUEST_MESSAGE : String
- BALL : String
- STRIKE : String
- NOTHING : String
