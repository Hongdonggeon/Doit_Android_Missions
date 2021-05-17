## this와 getApplicationContext()

- 안드로이드 스튜디오에서 context가 들어가야 할 곳에 this를 넣을때도 있고, getApplicationContext()를 넣을 때도 있다.
- 안드로이드에는 두 종류의 context가 있다.
- Application context
  - 어플리케이션 자체와 연동되는 것이므로, 어플리케이션의 life cycle이 지속되는 동안 동일한 객체이다. 즉 어플리케이션을 종료 후 다시 실행시킬 때에만 바뀌는 것이다.
- Activity context
  - 액티비티와 연동된 것이므로, 그 액티비티를 파괴시키고 다시 시작시키면 activity context도 바뀐다. (한 개의 어플리케이션 내에는 여러 액티비티를 넣을 수 있다.)
- getApplicationContext()가 application context를 가리키는 것이고, this가 activity context를 가리키는 것이다.
- 두 종류의 context중 어느 context를 써도 대부분 별 문제 없지만 this로 오류가 날때는 해당 액티비티가 없어서 그런 것이므로, getApplicationContext()를 넣으면 작동된다.
- this = getBaseContext() = Activity Context
- getApplicationContext() = getApplication = Application Context