# -Diplom_3
# запуск с Firefox
`mvn -Dbrowser=firefox test`

# запуск с Chrome
`mvn test`

# запуск конкретного теста
1. для теста testSuccessRegister mvn -Dtest=QuestionTest test - Chrome mvn -Dtest=QuestionTest -Dbrowser=firefox test - Firefox
2. для теста BunSauceFillingTest mvn -Dtest=OrderBlackScooterFor3days test - Chrome mvn -Dtest=OrderBlackScooterFor3days -Dbrowser=firefox test - Firefox 
3. для теста EnterInAccountTest mvn -Dtest=OrderGreyScooterFor5days test - Chrome mvn -Dtest=OrderGreyScooterFor5days -Dbrowser=firefox test - Firefox
