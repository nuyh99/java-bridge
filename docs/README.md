## 기능 구현 목록
- [x] 다리 길이 입력 받기
  * 3~20의 범위
- [ ] 다리 생성하기
  * 0과 1 중 무작위 값 사용
  * 위 칸을 건널 수 있으면 U, 아래 칸은 D
  * 무작위 값이 0인 경우 D, 1이면 U
  * 재시작해도 기존 다리 사용
- [ ] 사용자에게 이동할 칸 입력 받기
  - U 또는 D 입력
- [ ] 게임 승리 여부 판단 하기
  - 모두 건넜으면 승리
  - 현재 다리를 맞췄으면 계속
  - 현재 다리를 틀렸으면 재시도 여부 입력
- [ ] 게임 재시작 여부 입력 받기
  - R 또는 Q

## 프로그래밍 요구 사항
* InputView에서 Console.readLine() 사용
* BridgeGame에서 View 의존 금지
* InputView
  * 패키지 변경 가능
  * 메서드 변경 및 추가 가능
* OutputView
  * 패키지 변경 가능
  * 메서드 이름 변경 불가능
  * 인자, 반환 타입 변경 가능
  * 메서드 추가 가능
* BridgeGame
  * 필드 추가 가능
  * 패키지 변경 가능
  * 메서드 이름 변경 불가능
  * 인자, 반환 타입 변경 가능
  * 메서드 추가 가능
* BridgeMaker
  * 변경 불가능
* BridgeRandomNumberGenerator 관련
  * 변경 불가능
* Random 값 추출 BridgeRandomNumberGenerator.generate()