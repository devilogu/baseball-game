# 숫자 야구 게임(Baseball Game)
### 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임  
  
  
## 기능 요구사항  
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱  
- 컴퓨터가 서로 다른 임의의 수 3개를 선택  
- 플레이어가 3개의 숫자를 모두 맞히면 게임 종료  
- 게임이 끝나면 재시작 또는 완전히 종료 선택


## 구현할 기능  
#### <컴퓨터(Computer)>  
- 랜덤으로 숫자3개를 정한다.  
- 숫자3개는 중복이 없어야한다.  
- 숫자 중에 0이 있으면 안된다.

#### <플레이어(Player)>  
- 숫자3개를 중복없이 입력하도록 한다.  
- 3개가 아닌 수를 입력했을 경우 다시 입력하도록 한다.  
- 숫자 중에 0이 있으면 안된다.

#### <전체적 게임 틀>  
- 컴퓨터의 숫자와 플레이어의 숫자를 비교후 결과를 출력한다.
- 숫자 맞혔을 때(3스크라이크) 재시작 여부 묻는다.
