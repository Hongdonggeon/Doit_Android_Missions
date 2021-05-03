## 여러 화면 만들고 전환하기



### 안드로이드 앱의 기본 구성 요소

- 액티비티 (Activity)
- 서비스 (Service)
- 브로드캐스트 수신자 (Broadcast Receiver)
- 내용 제공자 (Content Provider)

안드로이드 시스템은 위 요소들에 대한 정보를 요구한다. 이 정보들은 Manifest 파일에 담겨 있다.



### StartActivity() vs StartActivityForResult()

- 액티비티를 소스 코드에서 띄울 때는 startActivity()와 StartActivityForResult()를 사용하면 된다.
- startActivity() 메서드는 단방향으로 단순히 액티비티만 열어준다.
- startActivityForResult() 메서드는 양방향으로 액티비티를 열어주고 원래의 액티비티로 돌아오면서 결과값을 전달해준다.



### StartActivityForResult(Intent intent, int requestCode)

- 이 메서드에 전달되는 파라미터는 '인텐트'와 '정수로 된 코드 값' 으로 코드 값은 일반적으로 각각의 액티비티를 구별하기 위해 사용된다.

- ```  java
  <MainActivity>
  public static final int REQUEST_CODE_MENU = 101;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      ...
  	Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
  	startActivityForResult(intent, REQUEST_CODE_MENU);
  }
  ```

- REQUEST_CODE_MENU는 새 액티비티를 띄울 때 보낼 요청 코드이다. 다른 액티비티와 중복되지 않게 지정하면 된다. 이 값은 나중에 새 액티비티로부터 응답을 받을 때 다시 전달받을 값이다.

- 인텐트 객체는 액티비티를 띄울 목적으로 사용되며 액티비티 간에 데이터를 전달하는 데에도 사용될 수 있다.

  - 위 코드는 MenuActivity 로 전달한다.



**setResult(RESULT_OK, intent)**

``` java
<MenuActivity>
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 ...
 	Intent intent = new Intent(); // 인텐트 객체 생성
 	intent.putExtra("name", "mike"); //인텐트 객체에 name의 값을 부가 데이터로 추가. (key, value) 형식으로 삽입
 	setResult(RESULT_OK, intent); // 응답 보내기

 	finish(); // 액티비트를 화면에서 없애고 싶을 때 사용
 } 
```

- setResult(응답코드, 인텐트)
- SubActivity 종료 시점에 작성한다.
- RESULT_OK 또는 RESULT_CANCEL을 보내도 된다.





**onActivityResult(int requestCode, int resultCode, Intent data)**

``` java
<MainActivity>
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     super.onActivityResult(requestCode, resultCode, data);

      if (requestCode == REQUEST_CODE_MENU) {
          Toast.makeText(getApplicationContext(),
          "onActivityResult 메소드 호출됨. 요청 코드 : " + requestCode +
                            ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG).show();
      if (resultCode == RESULT_OK) {
          String name = data.getStringExtra("name");
          Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name,
          Toast.LENGTH_LONG).show();
         }
     }
}
```

- 새로 띄웠던 메뉴 액티비티(서브 액티비티)가 응답을 보내오면 그 응답을 처리하는 역할을 한다.
- 첫번째 파라미터는 새 액티비티를 띄울 때 전달했던 요청코드와 같다. 이 값으로 어떤 액티비티로부터 응답을 받은 것인지 구분할 수 있다.
- 두번째 파라미터는 새 액티비티로부터 전달 된 응답 코드이다. 응답 코드는 새 액티비에서 처리한 결과가 정상인지 아닌지를 구분하는데 사용된다.
- 세번째 파라미터는 새 액티비티로부터 전달 받은 인텐트이다. 이 인텐트 안에 새 액티비트이 데이터를 전달할 때 사용한다.

